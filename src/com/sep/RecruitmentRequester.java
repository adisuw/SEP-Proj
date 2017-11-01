/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep;

/**
 *
 * @author ema
 */
public class RecruitmentRequester {

    private String contract;
    private String requester;
    private String experience;
    private String title;
    private String desc;
    public RecruitmentRequester(){
        
    }
    public RecruitmentRequester(String contract, String requester, String experience, String title, String desc) {
        this.contract = contract;
        this.requester = requester;
        this.experience = experience;
        this.title = title;
        this.desc = desc;
    }

    public String getContract() {
        return contract;
    }

    public String getRequester() {
        return requester;
    }

    public String getExperience() {
        return experience;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    

}
