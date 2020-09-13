
package com.leal.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TransactionDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("commerce")
    @Expose
    private CommerceDTO commerce;
    @SerializedName("branch")
    @Expose
    private BranchDTO branch;
    private final static long serialVersionUID = 2330001018165927435L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public CommerceDTO getCommerce() {
        return commerce;
    }

    public void setCommerceDTO(CommerceDTO commerceDTO) {
        this.commerce = commerceDTO;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", createdDate='" + createdDate + '\'' +
                ", commerce=" + commerce +
                ", branch=" + branch +
                '}';
    }
}
