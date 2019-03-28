package com.example.pmakkaraphon.freelancewroks.Model;

import java.util.List;

public class LoginModel {

    /**
     * code : 1
     * status : Success
     * message : Success
     * profile : {"id_mem":"cust1","pass_mem":"25f9e794323b453885f5181f1b624d0b","name_mem":"สมชาย","lname_mem":"สมชาย","address_mem":"333 ถนน วิภาวดีรังสิต","email_mem":"somsai@hotmail.com","tel_mem":"0652412521","idcard_mem":"2449093771241","type_mem":"customer","status_mem":"green","PROVINCE_NAME":"ปทุมธานี   ","AMPHUR_NAME":"หนองเสือ   ","DISTRICT_NAME":"บึงชำอ้อ   ","zipcode":"10125","work_history":"","skill_mem":"","money_mem":"9900.00","credit_mem":"0.00"}
     * portfolio : []
     * education : []
     * picMem : [{"pic_mem":"","pic_idcard_mem":"","bookbank":""}]
     */

    private int code;
    private String status;
    private String message;
    private ProfileBean profile;
    private List<?> portfolio;
    private List<?> education;
    private List<PicMemBean> picMem;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<?> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<?> portfolio) {
        this.portfolio = portfolio;
    }

    public List<?> getEducation() {
        return education;
    }

    public void setEducation(List<?> education) {
        this.education = education;
    }

    public List<PicMemBean> getPicMem() {
        return picMem;
    }

    public void setPicMem(List<PicMemBean> picMem) {
        this.picMem = picMem;
    }

    public static class ProfileBean {
        /**
         * id_mem : cust1
         * pass_mem : 25f9e794323b453885f5181f1b624d0b
         * name_mem : สมชาย
         * lname_mem : สมชาย
         * address_mem : 333 ถนน วิภาวดีรังสิต
         * email_mem : somsai@hotmail.com
         * tel_mem : 0652412521
         * idcard_mem : 2449093771241
         * type_mem : customer
         * status_mem : green
         * PROVINCE_NAME : ปทุมธานี  
         * AMPHUR_NAME : หนองเสือ  
         * DISTRICT_NAME : บึงชำอ้อ  
         * zipcode : 10125
         * work_history :
         * skill_mem :
         * money_mem : 9900.00
         * credit_mem : 0.00
         */

        private String id_mem;
        private String pass_mem;
        private String name_mem;
        private String lname_mem;
        private String address_mem;
        private String email_mem;
        private String tel_mem;
        private String idcard_mem;
        private String type_mem;
        private String status_mem;
        private String PROVINCE_NAME;
        private String AMPHUR_NAME;
        private String DISTRICT_NAME;
        private String zipcode;
        private String work_history;
        private String skill_mem;
        private String money_mem;
        private String credit_mem;

        public String getId_mem() {
            return id_mem;
        }

        public void setId_mem(String id_mem) {
            this.id_mem = id_mem;
        }

        public String getPass_mem() {
            return pass_mem;
        }

        public void setPass_mem(String pass_mem) {
            this.pass_mem = pass_mem;
        }

        public String getName_mem() {
            return name_mem;
        }

        public void setName_mem(String name_mem) {
            this.name_mem = name_mem;
        }

        public String getLname_mem() {
            return lname_mem;
        }

        public void setLname_mem(String lname_mem) {
            this.lname_mem = lname_mem;
        }

        public String getAddress_mem() {
            return address_mem;
        }

        public void setAddress_mem(String address_mem) {
            this.address_mem = address_mem;
        }

        public String getEmail_mem() {
            return email_mem;
        }

        public void setEmail_mem(String email_mem) {
            this.email_mem = email_mem;
        }

        public String getTel_mem() {
            return tel_mem;
        }

        public void setTel_mem(String tel_mem) {
            this.tel_mem = tel_mem;
        }

        public String getIdcard_mem() {
            return idcard_mem;
        }

        public void setIdcard_mem(String idcard_mem) {
            this.idcard_mem = idcard_mem;
        }

        public String getType_mem() {
            return type_mem;
        }

        public void setType_mem(String type_mem) {
            this.type_mem = type_mem;
        }

        public String getStatus_mem() {
            return status_mem;
        }

        public void setStatus_mem(String status_mem) {
            this.status_mem = status_mem;
        }

        public String getPROVINCE_NAME() {
            return PROVINCE_NAME;
        }

        public void setPROVINCE_NAME(String PROVINCE_NAME) {
            this.PROVINCE_NAME = PROVINCE_NAME;
        }

        public String getAMPHUR_NAME() {
            return AMPHUR_NAME;
        }

        public void setAMPHUR_NAME(String AMPHUR_NAME) {
            this.AMPHUR_NAME = AMPHUR_NAME;
        }

        public String getDISTRICT_NAME() {
            return DISTRICT_NAME;
        }

        public void setDISTRICT_NAME(String DISTRICT_NAME) {
            this.DISTRICT_NAME = DISTRICT_NAME;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getWork_history() {
            return work_history;
        }

        public void setWork_history(String work_history) {
            this.work_history = work_history;
        }

        public String getSkill_mem() {
            return skill_mem;
        }

        public void setSkill_mem(String skill_mem) {
            this.skill_mem = skill_mem;
        }

        public String getMoney_mem() {
            return money_mem;
        }

        public void setMoney_mem(String money_mem) {
            this.money_mem = money_mem;
        }

        public String getCredit_mem() {
            return credit_mem;
        }

        public void setCredit_mem(String credit_mem) {
            this.credit_mem = credit_mem;
        }
    }

    public static class PicMemBean {
        /**
         * pic_mem :
         * pic_idcard_mem :
         * bookbank :
         */

        private String pic_mem;
        private String pic_idcard_mem;
        private String bookbank;

        public String getPic_mem() {
            return pic_mem;
        }

        public void setPic_mem(String pic_mem) {
            this.pic_mem = pic_mem;
        }

        public String getPic_idcard_mem() {
            return pic_idcard_mem;
        }

        public void setPic_idcard_mem(String pic_idcard_mem) {
            this.pic_idcard_mem = pic_idcard_mem;
        }

        public String getBookbank() {
            return bookbank;
        }

        public void setBookbank(String bookbank) {
            this.bookbank = bookbank;
        }
    }
}
