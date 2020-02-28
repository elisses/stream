package br.com.elisvieira.diecast.report;
import br.com.elisvieira.diecast.model.DiecastModel;
import br.com.elisvieira.diecast.model.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ReportGenerator {

    public List<DiecastModel> findAllByTeam(List<DiecastModel> diecastModels, Team team) {
        return diecastModels.stream()
                .filter(i -> i.getTeam().equals(team))
                //.collect(Collectors.toList());
                .collect(toList());
    }

    public List<DiecastModel> findAllChampions(List<DiecastModel> diecastModels) {


        return diecastModels.stream()
                .filter(i -> i.getConstructorChampion() || i.getDriverChampion())
                .collect(Collectors.toList());
    }

    public Double sumTotalPrices(List<DiecastModel> diecastModels) {
        Double totalSum = diecastModels
                .stream()
                .map(diecastModel -> diecastModel.getPrice())
                .reduce(0., Double::sum);
        
        return totalSum;
    }

    public Map<Team, List<DiecastModel>> groupAllByTeam(List<DiecastModel> diecastModels) {


        Map<Team, List<DiecastModel>> diecastsByTeam = diecastModels.stream()
                .collect(groupingBy(diecastModel -> diecastModel.getTeam()));



        //Map<Team, List<DiecastModel>> diecastsByTeam = new HashMap<>();
       /* for (DiecastModel diecastModel : diecastModels) {
            Team team = diecastModel.getTeam();
            List<DiecastModel> diecastsFromSameTeam = diecastsByTeam.get(team);
            if (diecastsFromSameTeam == null) {
                diecastsFromSameTeam = new ArrayList<>();
            }
            diecastsFromSameTeam.add(diecastModel);
            diecastsByTeam.put(team, diecastsFromSameTeam);
        }*/

        return diecastsByTeam;
    }
}


