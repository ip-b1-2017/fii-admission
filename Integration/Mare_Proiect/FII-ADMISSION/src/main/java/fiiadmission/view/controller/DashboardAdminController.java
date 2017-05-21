package fiiadmission.view.controller;


import fiiadmission.ServerProperties;
import fiiadmission.dto.AdminStatisticsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardAdminController {
    @RequestMapping(value="/dashboard_admin", method= RequestMethod.GET)
    public ModelAndView dashboardAdmin(Model model, HttpServletRequest req){
        AdminStatisticsEntity statisticsEntity = getStatistics();
        Integer nrCandidates = Integer.parseInt(statisticsEntity.getNrChecked()) + Integer.parseInt(statisticsEntity.getNrUnchecked());
        model.addAttribute("nrCandidates", nrCandidates);
        model.addAttribute("checked", statisticsEntity.getNrChecked());
        model.addAttribute("unchecked",statisticsEntity.getNrUnchecked());
        return new ModelAndView("/dashboard_admin");
    }


    private AdminStatisticsEntity getStatistics(){
        RestTemplate restTemplate = new RestTemplate();
        /*
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });*/
        ResponseEntity<AdminStatisticsEntity> response = restTemplate.getForEntity(
                ServerProperties.middleUrl + "/statistics/get_admin_statistics",
                AdminStatisticsEntity.class
        );
        return response.getBody();
    }
}
