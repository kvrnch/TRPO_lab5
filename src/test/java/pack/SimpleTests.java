package pack;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class SimpleTests {
    @DataProvider(name = "FirstModuleData")
    public Object[][] createData1()
    {
        double max = Integer.MAX_VALUE - 1;
        double min = Integer.MIN_VALUE + 1;
        int n = (int)(Math.random() * max);
        int m = (int)(Math.random() * min);
        int s = n + m;
        return new Object[][]
                {
                        {s}
                };
    }
    @DataProvider(name = "SecondModule1Data")
    public Object[][] createData2()
    {
        double max = Integer.MAX_VALUE - 1;
        double min = Integer.MIN_VALUE + 1;
        int n = (int)(Math.random() * 1000);
        int m = (int)(Math.random() * 200);
        return new Object[][]
                {
                        {n, m}
                };
    }

    @DataProvider(name = "ThirdModule1Data")
    public Object[][] createData5()
    {
        double max = Integer.MAX_VALUE - 1;
        int n = 100;
        int m = 5;
        int result = n/m;
        return new Object[][]
                {
                        {n, m, result}
                };
    }
    @Test(dataProvider = "FirstModuleData")
    public void FirstModule(int n)
    {
        System.out.println("Тест 1. Проверка метода Math.abs(n): ");

        int m = Math.abs(n);
        System.out.println("n = " + n);
        System.out.println("Модуль n = " + m);
        if (n < 0) Assert.assertEquals(m,n * -1);
        else Assert.assertEquals(m, n);
        System.out.println();
    }
    @Test(dataProvider = "SecondModule1Data")
    public void SecondModule1(int n, int m)
    {
        System.out.println("Тест 2. Проверка метода Math.addExact: ");
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        int sum = Math.addExact(n,m);
        Assert.assertEquals(sum,n + m);
        System.out.println("Значение с помощью addExact = " + sum);
        System.out.println("Проверочное значение = " + (n + m));
        System.out.println();
    }

    @Test(dataProvider = "ThirdModule1Data")
    public void ThirdModule1(int n, int m, int res)
    {         //Происходит деление n на m и остаток округляется
        System.out.println("Тест 3. Проверка функции Math.floorDiv: ");
        int result = Math.floorDiv(n, m);
        System.out.println("Первое число = " + n + "; Второе число = "
                + m);
        System.out.println("Результат floorDiv: " + result);
        System.out.println("Проверка: " + res);
        Assert.assertEquals(result, res);
        System.out.println();
    }
}