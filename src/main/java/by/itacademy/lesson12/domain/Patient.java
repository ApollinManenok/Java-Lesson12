package by.itacademy.lesson12.domain;

import java.time.LocalDate;

public class Patient {
    private String name;
    private String surname;
    private LocalDate birth;
    private boolean status;

    public Patient() {
    }

    public Patient(String name, String surname, LocalDate birth, boolean status) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.status = status;
    }

    public Patient(String line) {
        this(line.split(";"));
    }

    public Patient(String[] fields) {
        this(fields[0], fields[1], fields[2], fields[3]);
    }

    public Patient(String name, String surname, String birthStr, String statusStr) {
        this(name, surname, LocalDate.parse(birthStr, PatientDateFormat.INSTANCE.format()), statusStr);
    }

    public Patient(String name, String surname, LocalDate birth, String statusStr) {
        this(name, surname, birth, Boolean.valueOf(statusStr));
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String[] getProperties() {
        String[] properties = {name, surname, birth.format(PatientDateFormat.INSTANCE.format()), String.valueOf(status)};
        return properties;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Patient patient = (Patient) other;
        if (!name.equals(patient.name)) return false;
        if (!surname.equals(patient.surname)) return false;
        return birth.equals(patient.birth);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + birth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Patient: " + name + " " + surname + " Date of birth: "
                + birth.format(PatientDateFormat.INSTANCE.format()) + ", Status: " + status + ";";
    }
}
