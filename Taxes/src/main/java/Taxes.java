/**Ajito, Monika Section 1790 Project: Computing Taxes*/
  
 import java.util.Scanner;
 
public class Taxes {
 public static void main(String[] args) {
  //Creating a scanner
  Scanner input =new Scanner(System.in);
   
  //User Input Status
  System.out.println("0-single filer,\n1-married jointly or qualifying widow(er),\n2-married separately,\n3-head of household.\nEnter the filing status: ");  
  int status = input.nextInt();
          
  //User Input Income
  System.out.println("Enter the taxable income: ");
  double income = input.nextDouble();
  
 //Tax Calculations
 double tax = 0;
 //Single
 if (status == 0) {
    if(income <= 8350)
        tax = income * .10;    
    else if (income <= 33950)
        tax = 8350 * .10 + (income -8350) * .15;       
    else if (income <= 82250)
        tax = 8350 *.10 + (33950 - 8350)  * .15 + (income -33950) * .25;
    else if (income <= 171550)
        tax = 8350 * .10 + (33950 - 8350) * .15 + (82250 -33950) * .25 + 
                (income - 82250) * .28;
    else if (income <= 372950) 
        tax = 8350 * 0.10 + (33950 - 8350) * .15 + (82250 -33950) * .25 + 
        (171550 -82250) * .28 + (income - 171550) * .33; 
    else
        tax = 8350 * .10 + (33950 - 8350) * .15 + (82250 -33950) * .25 +  
                (171550 - 82250) * .28 + (372950 -171550) * .33 
                + (income - 372950) * .35; 
 }
 
 //Married Jointly or qualifying widow(er)
 else if (status == 1) {
    if(income <= 16700)
        tax = income * .10;
    else if (income <= 67900)
        tax = 16700 * .10 + (income - 16700) * .15;
    else if (income <= 137050)
        tax = 16700 * .10 + (67900 - 16700) * .15 + (income - 67900) * .25;
    else if (income <= 208850)
        tax = 16700 * .10 + (67900 - 16700) * .15 + (137050 - 67900) * .25 + 
                (income - 137050) * .28;
    else if (income <= 372950)
        tax = 16700 * .10 + (67900 - 16700) * .15 + (137050 - 67900) * .25 + 
                (208850 - 137050) * .28 + (income - 208850) * .33;
    else
        tax = 16700 * .10 + (67900 - 16700) * .15 + (137050 - 67900) * .25 + 
                (208850 - 137050) * .28 + (372950 - 208850) * .33 + 
                (income - 372950) * .35;
 }
 
 //Married Filing Separetely 
 else if (status == 2) {
     if(income <= 8350)
         tax = income * .10;
     else if (income <= 33950)
         tax = 8350 * .10 + (income - 8350) * .15; 
     else if (income <= 68525)
         tax = 8350 * .10 + (33950 - 8350) * .15 + (income - 33950) * .25;
     else if (income <= 104425)
         tax = 8350 * .10 + (33950 - 8350) * .15 + (68525 - 33950) * .25 + 
                (income - 68525) * .28; 
     else if (income <= 186475)
         tax = 8350 * .10 + (33950 - 8350) * .15 + (68525 - 33950) * .25 + 
                 (104425 - 68525) * .28 + (income - 104425) * .33; 
     else 
         tax = 8350 * .10 + (33950 - 8350) * .15 + (68525 - 33950) * .25 +
                 (104425 - 68525) * .28 + (186475 - 104425) * .33 +
                 (income - 186475) * .35;
 }

//Head Of Household
 else if (status == 3) {
     if (income <= 11950)
         tax = income * .10;
     else if (income <= 45500)
         tax = 11950 * .10 + (income - 11950) * .15; 
     else if (income <= 117450)
         tax = 11950 * .10 + (45500 - 11950) * .15 + (income - 45500) * .25; 
     else if (income <= 190200)
         tax = 11950 * .10 + (45500 - 11950) * .15 + (117450 - 45500) * .25 +
                 (income - 117450) * .28; 
     else if (income <= 372950)
         tax = 11950 * .10 + (45500 - 11950) * .15 + (117450 - 45500) * .25 + 
                 (190200 - 117450) * .28 + (income - 190200) * .33;
     else 
         tax = 11950 * .10 + (45500 - 11950) * .15 + (117450 - 45500) * .25 +
                 (190200 - 117450) * .28 + (372950 - 190200) * .33 +
                 (income - 372950) * .35; 
 }
 
 else {
     System.out.println("Error: invalid status");
     System.exit(1);
 }
 
//Results
System.out.println("Tax is " + (int)(tax * 100) / 100.0);
 }
}