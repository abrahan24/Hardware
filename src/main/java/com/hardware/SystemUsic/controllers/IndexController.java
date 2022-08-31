package com.hardware.SystemUsic.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.zxing.qrcode.encoder.QRCode;
import com.hardware.SystemUsic.Metodos;
import com.hardware.SystemUsic.models.entity.Almacen;
import com.hardware.SystemUsic.models.entity.DetalleFalla;
import com.hardware.SystemUsic.models.entity.Persona;
import com.hardware.SystemUsic.models.entity.Servicio;
import com.hardware.SystemUsic.models.entity.TipoEquipo;
import com.hardware.SystemUsic.models.entity.Usuario;
import com.hardware.SystemUsic.models.service.IAlmacenService;
import com.hardware.SystemUsic.models.service.IDetalleFallaService;
import com.hardware.SystemUsic.models.service.IDetalleService;
import com.hardware.SystemUsic.models.service.IFallaService;
import com.hardware.SystemUsic.models.service.IPersonaService;
import com.hardware.SystemUsic.models.service.IProcedenciaService;
import com.hardware.SystemUsic.models.service.IServicioService;
import com.hardware.SystemUsic.models.service.ITipoEquipoService;
import com.hardware.SystemUsic.models.service.IUsuarioService;

@Controller
@RequestMapping("/hardware")
public class IndexController {

    @Autowired
    private IServicioService servicioService;
    @Autowired
    private IProcedenciaService procedenciaService;
    @Autowired
    private IDetalleFallaService detalleFallaService;
    @Autowired
    private IFallaService fallaService;
    @Autowired
    private IAlmacenService almacenService;
    @Autowired
    private IPersonaService personaService;
    @Autowired
    private ITipoEquipoService tipoEquipoService;
    @Autowired
    private IUsuarioService usuarioService;
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login (){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(Model model, @RequestParam("usuario")String usuario,@RequestParam("contrasena")String contrasena, RedirectAttributes flash, HttpServletRequest request){
        Usuario u=usuarioService.getUsuario(usuario, contrasena);

        model.addAttribute("usuario", u);
        if (u!=null) {
            HttpSession session = request.getSession(false);
    
            session = request.getSession(true);
            session.setAttribute("persona", u.getPersona());
            session.setAttribute("usuario", u);
            session.setAttribute("unidad", u.getPersona().getUnidad().getUnidad());
            
            return "redirect:/hardware-servicio/";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/")
    public String inicio(Model model,  @RequestParam(name = "validado", required = false) String validado){
        
        if (validado != null) {
            model.addAttribute("validado", validado);
        }
        model.addAttribute("tipoequipos", tipoEquipoService.findAll());

        return "inicio";
    }
    
    @RequestMapping(value = "/formCliente")
    public String formCliente(Model model){

        return "formCliente";
    }

    @RequestMapping(value = "verificar/{id}")
    public String verificar_id(Model model , @PathVariable("id")Long id,RedirectAttributes flash,@RequestParam(name = "succes",required = false) String succes){

        if (succes != null) {
            model.addAttribute("succes", succes);
        }
        model.addAttribute("tipoequipo", tipoEquipoService.findOne(id));
        return "verificar";
    }
    
    @RequestMapping(value = "/verificar", method = RequestMethod.POST)
    public String verificar(Model model, @RequestParam("ci")String ci, @RequestParam("id_tipoequipo")Long id_tipoequipo,RedirectAttributes flash){
        Persona persona= personaService.getCIpersona(ci);
        if (persona!=null) {
            model.addAttribute("persona", persona);
        }else{
            model.addAttribute("aux", true);
            flash.addAttribute("succes", "CI Ingresado No Registrado!");
            return "redirect:/hardware/verificar/"+id_tipoequipo;
        }
        model.addAttribute("tipoequipo", tipoEquipoService.findOne(id_tipoequipo));
        model.addAttribute("almacenes", almacenService.getAllAlmacenTipoEquipo(id_tipoequipo));
        model.addAttribute("procedencias", procedenciaService.findAll());
        return "formCliente";
    }

  @RequestMapping(value = "/servicio", method = RequestMethod.POST)
    public String registrarServicio(Model model,@RequestParam(name = "id_servicio",required = false)Long id_servicio, @Validated Persona persona,@RequestParam(name = "accesorio", required = false)String accesorio, @RequestParam("id_almacen")Long id_almacen , @RequestParam(name = "id_falla",required = false)Long [] id_falla, @RequestParam("id_procedencia")Long id_procedencia ,RedirectAttributes flash) throws FileNotFoundException, IOException{

        if (persona.getId_persona()!=null) {
            persona=personaService.findOne(persona.getId_persona());
        } else {
            personaService.save(persona);
        }
        Metodos metodos = new Metodos();

        Path rootPath = Paths.get("uploads/");
		Path rootAbsolutPath = rootPath.toAbsolutePath();


        Servicio servicio;
        if (id_servicio != null) {
            servicio = servicioService.findOne(id_servicio);
        }else{
            servicio = new Servicio();
        }
        servicio.setPersona(persona);
        servicio.setFecha_recepcion(new Date());
        servicio.setEstado("P");
        servicio.setProcedencia(procedenciaService.findOne(id_procedencia));
        servicio.setAlmacen(almacenService.findOne(id_almacen));
        servicio.setTipoEquipo(almacenService.findOne(id_almacen).getTipoEquipo());
  
        if (accesorio != null) {
            servicio.setAccesorio("1");
        }else{
            servicio.setAccesorio("0");
        }
        servicioService.save(servicio);
        servicio.setQr("QR_"+servicio.getId_servicio()+".png");
        metodos.QR("http://181.115.221.99:9999/hardware/seguimiento/"+servicio.getId_servicio(), rootAbsolutPath.toString() + "\\"+"QR_"+servicio.getId_servicio()+".png");
        servicioService.save(servicio);
        
       if (id_falla != null) {
        for (int i = 0; i < id_falla.length; i++) {
            DetalleFalla detalleFalla = new DetalleFalla();
            detalleFalla.setFalla(fallaService.findOne(id_falla[i]));
            detalleFalla.setFecha_registro(new Date());
            detalleFalla.setServicio(servicio);
            detalleFallaService.save(detalleFalla);
        }
       }
        flash.addAttribute("validado", "Registro Enviado Con Exito!");
        if (id_servicio != null) {
            return "redirect:/hardware-servicio/";
        }else{
            return "redirect:/hardware/";
        }
    }

    @RequestMapping(value = "/almacen/{id_almacen}")
	public String getContent1(@PathVariable(value = "id_almacen")Long id_almacen, Model model, HttpServletRequest request){
	
		model.addAttribute("almacen", almacenService.findOne(id_almacen));
       
		return "content :: content1";
	}

    @RequestMapping(value = "/seguimiento/{id_servicio}")
	public String seguimiento(@PathVariable(value = "id_servicio")Long id_servicio, Model model, HttpServletRequest request){
	
		model.addAttribute("servicio", servicioService.findOne(id_servicio));
       
		return "seguimiento";
	}

}

