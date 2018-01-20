package com.work.curioustools.okhttp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ansh on 20/1/18.
 */

public class Student {
    private String name;

    @SerializedName("roll_no")
    private String rollNo;

    private  int age;

    @SerializedName("class_details")
    private ClassDetails classDetails;

    @SerializedName("acadmic_details")
    private Acadamics acadmicDetails;

    public Student() {
    }
    public Student(String name, int age, String  rollNo, ClassDetails classDetails, Acadamics acadmicDetails) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.classDetails = classDetails;
        this.acadmicDetails = acadmicDetails;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getRollNo() {
        return rollNo;
    }
    public ClassDetails getClassDetails() {
        return classDetails;
    }
    public Acadamics getAcadmicDetails() {
        return acadmicDetails;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
    public void setClassDetails(ClassDetails classDetails) {
        this.classDetails = classDetails;
    }
    public void setAcadmicDetails(Acadamics acadmicDetails) {
        this.acadmicDetails = acadmicDetails;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", classDetails=" + classDetails +
                ", acadmicDetails=" + acadmicDetails +
                '}';
    }


    public class ClassDetails {
       private String year,stream;
       private List<String> subjects;  //neither array nor arraylis,, only List<>

        public ClassDetails() {
        }
        public ClassDetails(String year, String stream, List<String> subjects) {
            this.year = year;
            this.stream = stream;
            this.subjects = subjects;
        }

        public String getYear() {
            return year;
        }
        public void setYear(String year) {
            this.year = year;
        }
        public String getStream() {
            return stream;
        }
        public void setStream(String stream) {
            this.stream = stream;
        }
        public List<String> getSubjects() {
            return subjects;
        }
        public void setSubjects(List<String> subjects) {
            this.subjects = subjects;
        }

        @Override
        public String toString() {
            return "ClassDetails{" +
                    "year='" + year + '\'' +
                    ", stream='" + stream + '\'' +
                    ", subjects=" + subjects +
                    '}';
        }
    }
//  dont know much about json but if you ever needed to create an "object" of internal class,
//  you SHOULD make them public and NOT ptivate class acadmics{...
//  private class Acadamics {
    public class Acadamics {

        @SerializedName("previous_percentage")
        private String previousPercentage;

        @SerializedName("has_paid_fees")
        private Boolean hasPaidFees;

        public Acadamics() {
        }
        public Acadamics(String previousPercentage, Boolean hasPaidFees) {
            this.previousPercentage = previousPercentage;
            this.hasPaidFees = hasPaidFees;
        }

        public String getPreviousPercentage() {
            return previousPercentage;
        }
        public void setPreviousPercentage(String previousPercentage) {
            this.previousPercentage = previousPercentage;
        }
        public Boolean getHasPaidFees() {
            return hasPaidFees;
        }
        public void setHasPaidFees(Boolean hasPaidFees) {
            this.hasPaidFees = hasPaidFees;
        }

        @Override
        public String toString() {
            return "Acadamics{" +
                    "previousPercentage='" + previousPercentage + '\'' +
                    ", hasPaidFees=" + hasPaidFees +
                    '}';
        }
    }


}
