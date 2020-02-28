package br.com.elisvieira.report;

import br.com.elisvieira.diecast.model.DiecastModel;
import br.com.elisvieira.diecast.model.Driver;
import br.com.elisvieira.diecast.model.Team;
import br.com.elisvieira.diecast.report.ReportGenerator;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class ReportGeneratorTest {

    private final ReportGenerator reportGenerator = new ReportGenerator();

    private static final Team MCLAREN = new Team(1, "McLaren", "UK");
    private static final Team FERRARI = new Team(2, "Ferrari", "Italy");
    private static final Team MERCEDES = new Team(3, "Mercedes", "Germany");
    private static final Team WILLIAMS = new Team(4, "Williams", "UK");
    private static final Driver NORRIS = new Driver(1, "Lando Norris", "UK");
    private static final Driver HAMILTON = new Driver(2, "Lewis Hamilton", "UK");
    private static final Driver PROST = new Driver(3, "Alain Prost", "France");

    DiecastModel prost88 = new DiecastModel(1, MCLAREN, PROST, 1988, 300., true, false);
    DiecastModel norris19 = new DiecastModel(2, MCLAREN, NORRIS, 2019, 140., false, false);
    DiecastModel prost90 = new DiecastModel(3, FERRARI, PROST, 1990, 220., false, false);
    DiecastModel hamilton18 = new DiecastModel(4, MERCEDES, HAMILTON, 2018, 200., true, true);


    @Test
    public void returnsAllModelsFromTheSameTeam() {
        List<DiecastModel> diecastModels = new ArrayList<>();
        diecastModels.addAll(asList(prost88, norris19, prost90, hamilton18));

        assertThat(reportGenerator.findAllByTeam(diecastModels, MCLAREN))
                .containsExactlyInAnyOrder(prost88, norris19);
    }

    @Test
    public void returnsAllModelsWhereEitherDriverOrConstructorChampions() {
        DiecastModel prost93 = new DiecastModel(5, WILLIAMS, PROST, 1993, 300., true, true);

        List<DiecastModel> diecastModels = new ArrayList<>();
        diecastModels.addAll(asList(prost88, norris19, prost90, hamilton18, prost93));

        assertThat(reportGenerator.findAllChampions(diecastModels))
                .containsExactlyInAnyOrder(prost88, hamilton18, prost93);
    }

    @Test
    public void returnsSumOfTotalPrices() {
        List<DiecastModel> diecastModels = new ArrayList<>();
        diecastModels.addAll(asList(prost88, norris19, prost90));

        assertThat(reportGenerator.sumTotalPrices(diecastModels)).isEqualTo(660.);
    }

    @Test
    public void returnsModelsGroupedByTeams() {
        DiecastModel prost93 = new DiecastModel(5, WILLIAMS, PROST, 1993, 300., true, true);

        List<DiecastModel> diecastModels = new ArrayList<>();
        diecastModels.addAll(asList(prost88, norris19, prost90, hamilton18, prost93));

        assertThat(reportGenerator.groupAllByTeam(diecastModels))
                .containsExactlyInAnyOrderEntriesOf(ImmutableMap.of(
                        MCLAREN, asList(prost88, norris19),
                        FERRARI, asList(prost90),
                        MERCEDES, asList(hamilton18),
                        WILLIAMS, asList(prost93)
                ));

    }

}