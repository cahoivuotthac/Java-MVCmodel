package healthCareManagement;

import java.util.Date;

public class Model {

    private String idPatient;
    private String namePatient;
    private Date birthdate;
    private String address;
    private String phoneNum;
    private boolean gender;

    public Model(String idPatient, String namePatient, Date birthdate, String address, String phoneNum, boolean gender) {
        this.idPatient = idPatient;
        this.namePatient = namePatient;
        this.birthdate = birthdate;
        this.address = address;
        this.phoneNum = phoneNum;
        this.gender = gender;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

}
