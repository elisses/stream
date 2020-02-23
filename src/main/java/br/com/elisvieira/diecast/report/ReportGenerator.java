package br.com.elisvieira.diecast.report;
import br.com.elisvieira.diecast.model.DiecastModel;
import br.com.elisvieira.diecast.model.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

public class ReportGenerator {

    public List<DiecastModel> findAllByTeam(List<DiecastModel> diecastModels, Team team) {
        return diecastModels.stream()
                .filter(i -> i.getTeam().equals(team))
                //.collect(Collectors.toList());
                .collect(toList());
    }

    public List<DiecastModel> findAllChampions(List<DiecastModel> diecastModels) {
        List<DiecastModel> diecastModelsByCountry = new ArrayList<>();
        for (DiecastModel diecastModel : diecastModels) {
            if (diecastModel.getConstructorChampion() || diecastModel.getDriverChampion()) {
                diecastModelsByCountry.add(diecastModel);
            }
        }
        return diecastModelsByCountry;
    }

    public Double sumTotalPrices(List<DiecastModel> diecastModels) {
        Double totalSum = 0.;

        for (DiecastModel diecastModel : diecastModels) {
            totalSum += diecastModel.getPrice();
        }

        return totalSum;
    }

    public Map<Team, List<DiecastModel>> groupAllByTeam(List<DiecastModel> diecastModels) {
        Map<Team, List<DiecastModel>> diecastsByTeam = new HashMap<>();

        for (DiecastModel diecastModel : diecastModels) {
            Team team = diecastModel.getTeam();
            List<DiecastModel> diecastsFromSameTeam = diecastsByTeam.get(team);
            if (diecastsFromSameTeam == null) {
                diecastsFromSameTeam = new ArrayList<>();
            }
            diecastsFromSameTeam.add(diecastModel);
            diecastsByTeam.put(team, diecastsFromSameTeam);
        }

        return diecastsByTeam;
    }
}


