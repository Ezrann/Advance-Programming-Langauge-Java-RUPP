class Salary{
    private Double basicSalary;
    private Double bonus;
/* no arg constructor */
    public Salary(){
        this.basicSalary = 0.0;
        this.bonus = 0.0;
    }

    /* constructor with parameter */
    public Salary(Double basicSalary, Double bonus) {
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public void setBasicSalary(Double basicSalary){
        this.basicSalary = basicSalary;
    }
    public void setBonus(Double bonus){
        this.bonus = bonus;
    }
    // increase salary 10% = 10 / 100% = 0.1
    public void increaseSalary (){
        this.basicSalary *= 0.1;
    }
    // return the total salary
    public double getSalary (){
        return this.basicSalary + this.bonus;
    }
//    Display Total Salary
    public void displaySalary  () {
        Double totalSalary = getSalary();
        System.out.println("Total Salary: " + totalSalary);
    }
}
public  class Exercise7 {
    public static void main(String[] args) {
        Salary salary = new Salary();

        salary.setBasicSalary(50000.0);
        salary.setBonus(500.0);

        System.out.println("My salary before increase 10percent :" + salary);


        salary.increaseSalary();
        System.out.println("My salary after increase 10percent : " + salary.getSalary());

//        System.out.println(" Total of my salary : " + salary.getSalary());



    }
}



//An instance variable is a class property that can be different for each object