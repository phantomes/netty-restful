package com.phantomes.netty;

import com.phantomes.ApiHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.AsciiString;
import io.netty.handler.codec.http.*;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestHandler extends ChannelHandlerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HttpRequest){
            HttpRequest req = (HttpRequest) msg;
            if (HttpHeaderUtil.is100ContinueExpected(req)){
                ctx.write(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE));
            }

            FullHttpResponse response=
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK, Unpooled.wrappedBuffer(ApiHandler.transTo(ctx,msg)));
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,new AsciiString("application/json; charset=utf-8"));
            response.headers().set(HttpHeaderNames.TRANSFER_ENCODING,HttpHeaderValues.CHUNKED);

            boolean keepAlive = HttpHeaderUtil.isKeepAlive(req);
            if (!keepAlive){
                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
            }else{
                response.headers().set(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
                ctx.write(response);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        ctx.close();
        logger.error("error:{} , ctx closed ", cause.getMessage());
    }
}
