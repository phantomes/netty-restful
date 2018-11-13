package com.phantomes.common;

import com.phantomes.entity.User;

public class ListInfo extends Info {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Created by zhoumengkang on 5/1/16.
     */
    public static class UserInfo extends Info {
        private User user;

        public User getUser() {
            return user;
        }

        public UserInfo(User user) {
            this.user = user;
        }
    }

    public static class UserLite {
        private int    id;
        private String name;
        private String icon;
        private int    sex;
        private int    birthday;
        private int    status;
        private int    ts;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getBirthday() {
            return birthday;
        }

        public void setBirthday(int birthday) {
            this.birthday = birthday;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTs() {
            return ts;
        }

        public void setTs(int ts) {
            this.ts = ts;
        }

        @Override
        public String toString() {
            return "UserLite{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", icon='" + icon + '\'' +
                    ", sex=" + sex +
                    ", birthday=" + birthday +
                    ", status=" + status +
                    ", ts=" + ts +
                    '}';
        }
    }
}