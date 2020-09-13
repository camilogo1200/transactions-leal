
package com.leal.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CommerceDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("valueToPoints")
    @Expose
    private Integer valueToPoints;
    @SerializedName("branches")
    @Expose
    private List<BranchDTO> branches = null;
    private final static long serialVersionUID = 8536744283580432065L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValueToPoints() {
        return valueToPoints;
    }

    public void setValueToPoints(Integer valueToPoints) {
        this.valueToPoints = valueToPoints;
    }

    public List<BranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDTO> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "Commerce{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", valueToPoints=" + valueToPoints +
                ", branches=" + branches +
                '}';
    }
}
