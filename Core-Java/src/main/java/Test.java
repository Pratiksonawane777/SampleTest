import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("400.0");
        stringList.add("402.0");
        stringList.add("403.0");
        stringList.add("404.0");
        stringList.add("405.0");

        List<String> expected = new ArrayList<>();
        expected.add("400");
        expected.add("406");

//        //        way 1
//        boolean allExpectedPresent = expected.stream().anyMatch(expectedValue ->
//            stringList.stream().anyMatch(actualValue ->
//                actualValue.startsWith(expectedValue)
//            )
//        );
//
//        if (allExpectedPresent) {
//            System.out.println("expected values are present in the stringList.");
//        } else {
//            System.out.println("Not all expected values are present in the stringList.");
//        }

        //        way 2
        boolean allExpectedPresent2 = false;
        for (String expectedValue : expected) {
            for (String actualValue : stringList) {
                if (actualValue.startsWith(expectedValue)) {
                    allExpectedPresent2 = true;
                    break;
                }
            }
        }

        if (allExpectedPresent2) {
            System.out.println("expected values are present in the stringList.");
        } else {
            System.out.println("Not all expected values are present in the stringList.");
        }
    }

}

