package com.cyp.gitnewmodulewhole.entity;

import java.util.List;

public class Resources {

        private String id;

        private String parentId;

        private String icon;

        private String text;

        private String url;

        private String ext2;

        private String openType;

        private String resourceType;

        private String isAuth;

        private List<Resources> children;

        public Resources(){

        }

        public String getExt2() {
            return ext2;
        }

        public void setExt2(String ext2) {
            this.ext2 = ext2;
        }



        public String getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(String isAuth) {
            this.isAuth = isAuth;
        }



        public String getOpenType() {
            return openType;
        }



        public void setOpenType(String openType) {
            this.openType = openType;
        }



        public String getParentId() {
            return parentId;
        }


        public void setParentId(String parentId) {
            this.parentId = parentId;
        }


        public String getResourceType() {
            return resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
        }

        public Resources(ResourcesEntity entity){
            this.id = entity.getResourcesId();
            this.text = entity.getResourcesName();
            this.icon = entity.getExt1();
            this.parentId = entity.getParentId();
            this.url = entity.getUrl();
            this.openType = entity.getOpenType();
            this.resourceType = entity.getResourcesType();
            this.isAuth = entity.getIsAuth();
            this.ext2 = entity.getExt2();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<Resources> getChildren() {
            return children;
        }

        public void setChildren(List<Resources> children) {
            this.children = children;
        }

        public String getUrl() {
            return url;
        }


        public void setUrl(String url) {
            this.url = url;
        }


        public Resources clone(){
            Resources res = new Resources();
            res.id = this.id;
            res.parentId = this.parentId;
            res.text = this.text;
            res.icon = this.icon;
            res.url = this.url;
            res.openType = this.openType;
            res.resourceType = this.resourceType;
            res.isAuth = this.isAuth;
            res.ext2 = this.ext2;
            return res;
        }



}
