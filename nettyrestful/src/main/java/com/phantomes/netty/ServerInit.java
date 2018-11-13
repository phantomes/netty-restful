package com.phantomes.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


public class ServerInit extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline chp=socketChannel.pipeline();
        chp.addLast(new HttpServerCodec());
        chp.addLast(new HttpContentCompressor());
        chp.addLast(new HttpObjectAggregator(1024*10));
        chp.addLast(new ChunkedWriteHandler());
        chp.addLast(new RestHandler());

    }
}
