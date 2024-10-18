package org.youcode;

import org.youcode.cyclist.Cyclist;

import java.util.List;

public class UiHelper {

    public static void fetchCyclists(List<Cyclist> cyclists){
        cyclists.stream()
                .forEach(c -> System.out.println(c.getFirstName() + "|" + c.getLastName() + "|" + c.getNationality() +"|" + c.getTeam().getName()));
    }

}
