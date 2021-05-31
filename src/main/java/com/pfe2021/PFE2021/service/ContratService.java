package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.repository.ContratRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
@Transactional
public class ContratService {

    private final ContratRepository contratRepository;

    @Autowired
    public ContratService (ContratRepository contratRepository){
        this.contratRepository = contratRepository;
    }

    public List<Contrat> findAllContrats(){
        return contratRepository.findAll();
    }

    public Contrat findContratById(Long id){
        return contratRepository.findContratById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public Contrat addContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    public Contrat updateContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    public void deleteContrat(Long id){
        contratRepository.deleteContratById(id);
    }

    //Jaspersoft reporting tool
    public String exportReport(Long idContrat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\dell\\PFE2021\\src\\assets\\reports";
        Contrat contrat = contratRepository.findContratById(idContrat).get();
        List<Contrat> contrats = new ArrayList<>();
        contrats.add(contrat);
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:contrat.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(contrats);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Arabsoft");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\contrat_"+contrat.getId()+".pdf");
        
        return "contrat_"+contrat.getId()+" généré avec succès dans: " + path;
    }
}
