package com.example.atividade3.controllers;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ProjetoDTO projetoDto) {
        projetoService.adicionarProjeto(projetoDto);
    }
    
    @GetMapping("/buscar/{id}")
    public ProjetoDTO getPorId(@PathVariable Integer id) {
        return projetoService.buscarProjetoPorId(id);
    }
    
    @PostMapping("/vincularFuncionario/{idProjeto}/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping("/buscarEntreDatas/{dataInicio}/{dataFim}")
    public List<ProjetoDTO> getMethodName(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim) {
        return projetoService.buscarProjetosPorPeriodo(dataInicio, dataFim);
    }
    

}
