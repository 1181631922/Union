package com.education.union.model;

import java.util.Date;

public class Class {
    private Integer id;

    private String name;

    private Integer classId;

    private Integer courseCount;

    private Integer courseTotalCount;

    private Integer personCount;

    private Integer personTotalCount;

    private Date beginTime;

    private Date endTime;

    private Integer status;

    private Integer upTime;

    private Boolean deleteStatus;

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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public Integer getCourseTotalCount() {
        return courseTotalCount;
    }

    public void setCourseTotalCount(Integer courseTotalCount) {
        this.courseTotalCount = courseTotalCount;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Integer getPersonTotalCount() {
        return personTotalCount;
    }

    public void setPersonTotalCount(Integer personTotalCount) {
        this.personTotalCount = personTotalCount;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUpTime() {
        return upTime;
    }

    public void setUpTime(Integer upTime) {
        this.upTime = upTime;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}