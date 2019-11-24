package control.students.studentscontrol;

public final class NameGenerator { //tempopary class
    private static String[] n1 = {"Дмитрий", "Егор", "Павел", "Алексей", "Александр", "Илья"};
    private static String[] n2 = {"Дмитриевич", "Егорович", "Павлович", "Алексеевич", "Александрович"};
    private static String[] n3 = {"Пушкин", "Лермонтов", "Бродский", "Маяковский", "Есенин"};

    public static String getRandomFirstName() { return n1[(int)(Math.random() * n1.length)]; }
    public static String getRandomSecondName() { return n2[(int)(Math.random() * n2.length)]; }
    public static String getRandomLastName() { return n3[(int)(Math.random() * n3.length)]; }
}
