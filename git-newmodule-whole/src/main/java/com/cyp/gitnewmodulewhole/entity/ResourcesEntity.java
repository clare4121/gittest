package com.cyp.gitnewmodulewhole.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ResourcesEntity {

        private String resourcesId;

        private String parentId;

        private String appSystemId;

        private String resourcesType;

        private String openType;

        private String resourcesName;

        private String url;

        private String resourcesIcon;

        private String ext1;

        private String ext2;

        private String ext3;

        private String ext4;

        private String memo;

        private BigDecimal ord;

        private String path;

        private String createPersion;

        private Date createDate;

        private String updatePersion;

        private Date updateDate;

        private String isAuth;

        private List<ResourcesEntity> children;

        public String getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(String isAuth) {
            this.isAuth = isAuth;
        }

        public List<ResourcesEntity> getChildren() {
            return children;
        }

        public void setChildren(List<ResourcesEntity> children) {
            this.children = children;
        }

        public String getResourcesId() {
            return resourcesId;
        }

        public void setResourcesId(String resourcesId) {
            this.resourcesId = resourcesId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getAppSystemId() {
            return appSystemId;
        }

        public void setAppSystemId(String appSystemId) {
            this.appSystemId = appSystemId;
        }

        public String getResourcesType() {
            return resourcesType;
        }

        public void setResourcesType(String resourcesType) {
            this.resourcesType = resourcesType;
        }

        public String getOpenType() {
            return openType;
        }

        public void setOpenType(String openType) {
            this.openType = openType;
        }

        public String getResourcesName() {
            return resourcesName;
        }

        public void setResourcesName(String resourcesName) {
            this.resourcesName = resourcesName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getResourcesIcon() {
            return resourcesIcon;
        }

        public void setResourcesIcon(String resourcesIcon) {
            this.resourcesIcon = resourcesIcon;
        }

        public String getExt1() {
            return ext1;
        }

        public void setExt1(String ext1) {
            this.ext1 = ext1;
        }

        public String getExt2() {
            return ext2;
        }

        public void setExt2(String ext2) {
            this.ext2 = ext2;
        }

        public String getExt3() {
            return ext3;
        }

        public void setExt3(String ext3) {
            this.ext3 = ext3;
        }

        public String getExt4() {
            return ext4;
        }

        public void setExt4(String ext4) {
            this.ext4 = ext4;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public BigDecimal getOrd() {
            return ord;
        }

        public void setOrd(BigDecimal ord) {
            this.ord = ord;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getCreatePersion() {
            return createPersion;
        }

        public void setCreatePersion(String createPersion) {
            this.createPersion = createPersion;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public String getUpdatePersion() {
            return updatePersion;
        }

        public void setUpdatePersion(String updatePersion) {
            this.updatePersion = updatePersion;
        }

        public Date getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }

        public ResourcesEntity clone(){
            ResourcesEntity entity = new ResourcesEntity();
            entity.setResourcesId(this.resourcesId);
            entity.setParentId      (this.parentId 		  );
            entity.setAppSystemId		(this.appSystemId 	);
            entity.setResourcesType (this.resourcesType );
            entity.setOpenType			(this.openType 		  );
            entity.setResourcesName (this.resourcesName );
            entity.setUrl						(this.url 					);
            entity.setResourcesIcon (this.resourcesIcon );
            entity.setExt1					(this.ext1 				  );
            entity.setExt2					(this.ext2 				  );
            entity.setExt3					(this.ext3 				  );
            entity.setExt4					(this.ext4 				  );
            entity.setMemo					(this.memo 				  );
            entity.setOrd						(this.ord 					);
            entity.setPath					(this.path 				  );
            entity.setCreatePersion (this.createPersion );
            entity.setCreateDate		(this.createDate 	  );
            entity.setUpdatePersion (this.updatePersion );
            entity.setUpdateDate		(this.updateDate 	  );
            entity.setChildren			(this.children 		  );
            return entity;
        }



}
