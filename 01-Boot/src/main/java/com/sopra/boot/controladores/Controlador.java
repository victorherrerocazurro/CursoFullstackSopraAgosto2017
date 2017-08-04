package com.sopra.boot.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sopra.boot.dto.Usuario;

@Controller
@RequestMapping(path="/api")
public class Controlador {
	
	// http://..../api/alta?id=1&nombre=victor&accion=actualizar
	
	@RequestMapping(path="/alta")
	//Posibles tipos de retorno void, String, View y ModelAndView
	public String alta(Usuario usuario, @RequestParam String accion, Model model, HttpServletRequest request){
		
		//Se invocaria la logica de negocio
		model.addAttribute("usuario", new Usuario(1, "Victor"));
		//request.setAttribute("usuario", new Usuario(1, "Victor"));//Equivalente a la anterior sentencia
		
		return "alta";
	}
	
	@RequestMapping(path="/consulta/{id}")
	//Posibles tipos de retorno void, String, View y ModelAndView
	public ModelAndView consultaPorId(@PathVariable int id){
		
		//Se invocaria la logica de negocio
		
		ModelAndView resultado = new ModelAndView("consulta");
		
		resultado.addObject("usuario", new Usuario(1, "Victor"));
		
		return resultado;
	}
	
}








