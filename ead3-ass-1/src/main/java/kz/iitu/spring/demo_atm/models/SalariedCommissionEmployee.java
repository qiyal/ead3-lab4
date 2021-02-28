package kz.iitu.spring.demo_atm.models;

public class SalariedCommissionEmployee extends Employee {
    private Double percentageSales;

    public SalariedCommissionEmployee() {}

    public SalariedCommissionEmployee(Integer id, String name, Double salary, Double percentageSales) {
        super(id, name, salary);
        this.percentageSales = percentageSales;
    }

    public Double getPercentageSales() {
        return percentageSales;
    }

    @Override
    public String toString() {
        return "SalariedCommissionEmployee{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", salary=" + getSalary() +
                ", percentageSales=" + percentageSales +
                '}';
    }
}
