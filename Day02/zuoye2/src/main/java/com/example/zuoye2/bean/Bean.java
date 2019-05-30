package com.example.zuoye2.bean;

import java.util.ArrayList;

public class Bean {

    /**
     * code : 200
     * message : 成功!
     * result : [{"sid":"29512047","text":"男孩沉迷游戏5年没有离开房间，父母打开门后发现已经不是人了","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0528/012f19d8810811e98a21842b2b4c75ab_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0528/012f19d8810811e98a21842b2b4c75ab_wpd.mp4","images":null,"up":"80","down":"4","forward":"0","comment":"1","uid":"22904210","name":"影视大魔王","header":"http://wimg.spriteapp.cn/profile/20180809180440623894.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-05-30 02:59:01"},{"sid":"29515640","text":"监控下拍到搞笑的一幕，这个小偷是新手吧，咋这么逗呢","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2019/0529/2818a0da81c311e9b9fd842b2b4c75ab_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2019/0529/2818a0da81c311e9b9fd842b2b4c75ab_wpd.mp4","images":null,"up":"137","down":"7","forward":"0","comment":"2","uid":"22904177","name":"热门搞笑","header":"http://wimg.spriteapp.cn/profile/20180809174201651651.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2019-05-30 02:19:02"}]
     */

    private int code;
    private String message;
    private ArrayList<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ResultBean> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sid : 29512047
         * text : 男孩沉迷游戏5年没有离开房间，父母打开门后发现已经不是人了
         * type : video
         * thumbnail : http://wimg.spriteapp.cn/picture/2019/0528/012f19d8810811e98a21842b2b4c75ab_wpd.jpg
         * video : http://uvideo.spriteapp.cn/video/2019/0528/012f19d8810811e98a21842b2b4c75ab_wpd.mp4
         * images : null
         * up : 80
         * down : 4
         * forward : 0
         * comment : 1
         * uid : 22904210
         * name : 影视大魔王
         * header : http://wimg.spriteapp.cn/profile/20180809180440623894.jpg
         * top_comments_content : null
         * top_comments_voiceuri : null
         * top_comments_uid : null
         * top_comments_name : null
         * top_comments_header : null
         * passtime : 2019-05-30 02:59:01
         */

        private String sid;
        private String text;
        private String type;
        private String thumbnail;
        private String video;
        private Object images;
        private String up;
        private String down;
        private String forward;
        private String comment;
        private String uid;
        private String name;
        private String header;
        private Object top_comments_content;
        private Object top_comments_voiceuri;
        private Object top_comments_uid;
        private Object top_comments_name;
        private Object top_comments_header;
        private String passtime;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getDown() {
            return down;
        }

        public void setDown(String down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public Object getTop_comments_content() {
            return top_comments_content;
        }

        public void setTop_comments_content(Object top_comments_content) {
            this.top_comments_content = top_comments_content;
        }

        public Object getTop_comments_voiceuri() {
            return top_comments_voiceuri;
        }

        public void setTop_comments_voiceuri(Object top_comments_voiceuri) {
            this.top_comments_voiceuri = top_comments_voiceuri;
        }

        public Object getTop_comments_uid() {
            return top_comments_uid;
        }

        public void setTop_comments_uid(Object top_comments_uid) {
            this.top_comments_uid = top_comments_uid;
        }

        public Object getTop_comments_name() {
            return top_comments_name;
        }

        public void setTop_comments_name(Object top_comments_name) {
            this.top_comments_name = top_comments_name;
        }

        public Object getTop_comments_header() {
            return top_comments_header;
        }

        public void setTop_comments_header(Object top_comments_header) {
            this.top_comments_header = top_comments_header;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }
    }
}
