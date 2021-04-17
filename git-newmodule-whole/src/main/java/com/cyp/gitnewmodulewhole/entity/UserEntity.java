package com.cyp.gitnewmodulewhole.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserEntity {


        private String userId;

        private String loginId;

        private String password;

        private String userName;

        private String idCard;

        private String sex;

        private String emall;

        private String mobile;

        private String telephone;

        private Date passwordDate;

        private String userAddress;

        private String userPosition;

        private String state;

        private String memo;

        private Date lockDate;

        private BigDecimal lockLoginTimes;

        private Date pwdUpdateDate;

        private Date createDate;

        private String createPersion;

        private String skin;

        private Date updateDate;

        private String updatePersion;


        private String prvoNo;

        private String prvoName;

        private String areaNo;

        private String areaName;

        public String getPrvoNo() {
            return prvoNo;
        }

        public void setPrvoNo(String prvoNo) {
            this.prvoNo = prvoNo;
        }

        public String getPrvoName() {
            return prvoName;
        }

        public void setPrvoName(String prvoName) {
            this.prvoName = prvoName;
        }

        public String getAreaNo() {
            return areaNo;
        }

        public void setAreaNo(String areaNo) {
            this.areaNo = areaNo;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }



        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getEmall() {
            return emall;
        }

        public void setEmall(String emall) {
            this.emall = emall;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public Date getPasswordDate() {
            return passwordDate;
        }

        public void setPasswordDate(Date passwordDate) {
            this.passwordDate = passwordDate;
        }

        public String getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        public String getUserPosition() {
            return userPosition;
        }

        public void setUserPosition(String userPosition) {
            this.userPosition = userPosition;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Date getLockDate() {
            return lockDate;
        }

        public void setLockDate(Date lockDate) {
            this.lockDate = lockDate;
        }

        public BigDecimal getLockLoginTimes() {
            return lockLoginTimes;
        }

        public void setLockLoginTimes(BigDecimal lockLoginTimes) {
            this.lockLoginTimes = lockLoginTimes;
        }

        public Date getPwdUpdateDate() {
            return pwdUpdateDate;
        }

        public void setPwdUpdateDate(Date pwdUpdateDate) {
            this.pwdUpdateDate = pwdUpdateDate;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public String getCreatePersion() {
            return createPersion;
        }

        public void setCreatePersion(String createPersion) {
            this.createPersion = createPersion;
        }

        public Date getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }

        public String getUpdatePersion() {
            return updatePersion;
        }

        public void setUpdatePersion(String updatePersion) {
            this.updatePersion = updatePersion;
        }
        @Override
        public String toString() {
            return "UserEntity [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", userName="
                    + userName + ", idCard=" + idCard + ", sex=" + sex + ", emall=" + emall + ", mobile=" + mobile
                    + ", telephone=" + telephone + ", passwordDate=" + passwordDate + ", userAddress=" + userAddress
                    + ", userPosition=" + userPosition + ", state=" + state + ", memo=" + memo + ", lockDate=" + lockDate
                    + ", lockLoginTimes=" + lockLoginTimes + ", pwdUpdateDate=" + pwdUpdateDate + ", createDate="
                    + createDate + ", createPersion=" + createPersion + ", updateDate=" + updateDate + ", updatePersion="
                    + updatePersion + "]";
        }
}
