package employee_idcard_system;

import java.io.Serializable;

public class IDCard implements Serializable {

    private Integer id;
    private String cardNumber;
    private String issueDate;

    public IDCard() {}

    public IDCard(Integer id, String cardNumber, String issueDate) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}