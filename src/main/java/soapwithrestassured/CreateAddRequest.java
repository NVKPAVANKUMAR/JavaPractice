package soapwithrestassured;

public class CreateAddRequest {

    private int firstNumber;
    public CreateAddRequest setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
        return this;
    }


    private int secondNumber;
    public CreateAddRequest setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
        return this;
    }




    public String done() {
        return "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <tem:Add>\n" +
                "         <tem:intA>"+ firstNumber +"</tem:intA>\n" +
                "         <tem:intB>"+ secondNumber +"</tem:intB>\n" +
                "      </tem:Add>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
    }

    public int getAdditionResult(){
        return firstNumber+secondNumber;
    }

}
