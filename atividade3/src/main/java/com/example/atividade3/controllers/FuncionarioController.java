package com.example.atividade3.controllers;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionar(funcionarioDTO);
    }
    
    @GetMapping("/buscarProjetos/{idFuncionario}")
    public List<ProjetoDTO> getProjetosPorFuncionario(@PathVariable Integer idFuncionario) {
        return funcionarioService.buscarProjetosPorFuncionarioId(idFuncionario);
    }
    
    
}
