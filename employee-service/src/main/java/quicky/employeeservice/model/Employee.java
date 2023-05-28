package quicky.employeeservice.model;

public record Employee(
        Long id,
        Long deparment,
        String name,
        int age,
        String position
        ) {
}
