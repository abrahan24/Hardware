package com.hardware.SystemUsic.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hardware.SystemUsic.models.dao.ICargoDao;
import com.hardware.SystemUsic.models.entity.Almacen;
import com.hardware.SystemUsic.models.entity.Cargo;
import com.hardware.SystemUsic.models.entity.Colaborador;
import com.hardware.SystemUsic.models.entity.DetalleSolucion;
import com.hardware.SystemUsic.models.entity.Persona;
import com.hardware.SystemUsic.models.entity.Previo;
import com.hardware.SystemUsic.models.entity.Servicio;
import com.hardware.SystemUsic.models.entity.TipoEquipo;
import com.hardware.SystemUsic.models.entity.Unidad;
import com.hardware.SystemUsic.models.entity.Usuario;
import com.hardware.SystemUsic.models.service.IAlmacenService;
import com.hardware.SystemUsic.models.service.IBajaService;
import com.hardware.SystemUsic.models.service.ICargoService;
import com.hardware.SystemUsic.models.service.IColaboradorService;
import com.hardware.SystemUsic.models.service.IDetalleSolucionService;
import com.hardware.SystemUsic.models.service.IPersonaService;
import com.hardware.SystemUsic.models.service.IPrevioService;
import com.hardware.SystemUsic.models.service.IProcedenciaService;
import com.hardware.SystemUsic.models.service.IServicioService;
import com.hardware.SystemUsic.models.service.ISolucionService;
import com.hardware.SystemUsic.models.service.ITipoEquipoService;
import com.hardware.SystemUsic.models.service.IUnidadService;
import com.hardware.SystemUsic.models.service.IUsuarioService;

@Controller
@RequestMapping("/hardware-servicio")
public class servicioController {

    @Autowired
    private IUnidadService unidadService;

    @Autowired
    private ICargoService cargoService;

    @Autowired
    private ITipoEquipoService tipoEquipoService;

    @Autowired
    private IAlmacenService almacenService;

    @Autowired
    private IColaboradorService colaboradorService;

    @Autowired
    private IProcedenciaService procedenciaService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IServicioService servicioService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IBajaService bajaService;

    @Autowired
    private ISolucionService solucionService;

    @Autowired
    private IDetalleSolucionService detalleSolucionService;

    @RequestMapping("/")
    public String servicios(Model model,RedirectAttributes flash, HttpServletRequest request , @RequestParam(name = "validado",required = false)String validado){

        if (request.getSession().getAttribute("persona") != null) {
			Persona persona = (Persona) request.getSession().getAttribute("persona");
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            
            persona = personaService.findOne(persona.getId_persona()); 
            usuario = usuarioService.findOne(usuario.getId_usuario());

            if (validado != null ) {
                model.addAttribute("validado", validado);
            }
            /* for (Previo previo : usuario.getPrevios()) {
                System.out.println(previo.getProcedencia().getProcedencia());
            } */
            for (Previo previo : usuario.getPrevios()) {
                model.addAttribute("servicios" + previo.getId_previo() , servicioService.getAllServicioUsuario(previo.getId_previo()));
            }
            model.addAttribute("previos", usuario.getPrevios());
            model.addAttribute("usuarios", usuarioService.findAll());
            
            return "panel";
		} else {
			return "redirect:/hardware/login";
		}
	}

    @RequestMapping("/eliminar_servicio/{id_servicio}")
    public String eliminarServicios(Model model, @PathVariable("id_servicio")Long id_servicio, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
			
            Servicio servicio = servicioService.findOne(id_servicio);
            servicio.setEstado(null);
            servicioService.save(servicio);
            flash.addAttribute("validado", "Regisro Eliminado Con Exito!");
            
            return "redirect:/hardware-servicio/";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/terminar_servicio/{id_servicio}")
    public String terminarServicios(Model model, @PathVariable("id_servicio")Long id_servicio, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
			
            Servicio servicio = servicioService.findOne(id_servicio);
            servicio.setEstado("T");
            servicio.setFecha_entrega(new Date());
            servicioService.save(servicio);
            flash.addAttribute("validado", "Servicio Terminado Con Exito!");
            
            return "redirect:/hardware-servicio/";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/aceptar_servicio/{id_servicio}")
    public String aceptarServicio(Model model,  @PathVariable("id_servicio")Long id_servicio, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
			Persona persona = (Persona) request.getSession().getAttribute("persona");
            persona = personaService.findOne(persona.getId_persona());
            Servicio servicio = servicioService.findOne(id_servicio);
            servicio.setEstado("A");

            servicioService.save(servicio);
            Colaborador colaborador = new Colaborador();
            colaborador.setPersona(persona);
            colaborador.setServicio(servicio);
            colaborador.setEstado("A");
            colaborador.setFecha_recepcion(new Date());
            colaboradorService.save(colaborador);

            flash.addAttribute("validado", "Recepcion Realizada Con Exito!");
            
            return "redirect:/hardware-servicio/";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/ficha_tecnica/{id_servicio}")
    public String fichaTecnicaServicio(Model model, @PathVariable("id_servicio")Long id_servicio, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
			
            flash.addAttribute("validado", "Recepcion Realizada Con Exito!");
            
            return "redirect:/hardware-servicio/";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/add_Cargo_Unidad")
    public String add_Cargo_Unidad_Service(Model model,@RequestParam(name = "validado",required = false)String validado,@RequestParam(name = "validado_",required = false)String validado_, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
        
            if (validado != null && validado_ != null) {
                model.addAttribute("validado", validado);
                model.addAttribute("validado_", validado_);
            }
            
            return "add_Cargo_Unidad";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/add_cargo", method = RequestMethod.POST)
    public String add_Cargo(Model model,@RequestParam(name = "cargo",required = false)String cargo_,@RequestParam(name = "id_cargo",required = false)Long id_cargo, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
			Cargo cargo = new Cargo();
            cargo.setId_cargo(id_cargo);
            cargo.setCargo(cargo_);
            cargo.setCodigo(null);
            cargoService.save(cargo);
            flash.addAttribute("validado", "Cargo Agregado Con Exito!");
            
            return "redirect:/hardware-servicio/add_Cargo_Unidad";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/add_unidad", method = RequestMethod.POST)
    public String add_Unidad(Model model,@RequestParam(name = "unidad",required = false)String unidad_,@RequestParam(name = "id_unidad",required = false)Long id_unidad, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
			Unidad unidad = new Unidad();
            unidad.setId_unidad(id_unidad);
            unidad.setUnidad(unidad_);
            unidadService.save(unidad);
            flash.addAttribute("validado_", "Unidad Agregada Con Exito!");
            
            return "redirect:/hardware-servicio/add_Cargo_Unidad";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/add_Persona")
    public String add_Persona_Service(Model model,@RequestParam(name = "validado",required = false)String validado, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
        
            if (validado != null) {
                model.addAttribute("validado", validado);
            }
            model.addAttribute("unidades", unidadService.findAll());
            model.addAttribute("cargos", cargoService.findAll());
            
            return "add_Persona";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/add_persona", method = RequestMethod.POST)
    public String add_Persona(Model model,@RequestParam(name = "id_persona", required = false)Long id_persona,@RequestParam("nombre")String nombre,@RequestParam("ap_paterno")String ap_paterno,@RequestParam("ap_materno")String ap_materno,@RequestParam("ci")String ci,@RequestParam("celular")Integer celular,@RequestParam(name = "id_unidad",required = false)Long id_unidad,@RequestParam(name = "id_cargo",required = false)Long id_cargo, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
			Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setAp_paterno(ap_paterno);
            persona.setAp_materno(ap_materno);
            persona.setCi(ci);
            persona.setCelular(celular);
            persona.setCargo(cargoService.findOne(id_cargo));
            persona.setUnidad(unidadService.findOne(id_unidad));
            persona.setId_persona(id_persona);
            personaService.save(persona);

            flash.addAttribute("validado", "Persona Agregada Con Exito!");
            
            return "redirect:/hardware-servicio/add_Persona";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/add_informe", method = RequestMethod.POST)
    public String informeTecnicoServicio(Model model, @RequestParam("conclucion")String conclucion, @RequestParam("recomendacion")String recomendacion,@RequestParam("observacion")String observacion, @RequestParam(name = "id_servicio",required = false)Long id_servicio, @RequestParam(name = "id_solucion",required = false)Long [] id_solucion, RedirectAttributes flash, HttpServletRequest request){

        if (request.getSession().getAttribute("persona") != null) {
            
            Servicio servicio = servicioService.findOne(id_servicio);
                servicio.setConclucion(conclucion);
                servicio.setRecomendacion(recomendacion);
                servicio.setObservacion(observacion);
                servicio.setEstado("B");
                servicioService.save(servicio);

            if (id_solucion != null) {               
               for (int i = 0; i < id_solucion.length; i++) {
                DetalleSolucion detalleSolucion = new DetalleSolucion();
                detalleSolucion.setSolucion(solucionService.findOne(id_solucion[i]));
                detalleSolucion.setServicio(servicioService.findOne(id_servicio));
                detalleSolucionService.save(detalleSolucion);
               } 
            }
          
            flash.addAttribute("validado", "Informe Realizado Con Exito!");
            
            return "redirect:/hardware-servicio/";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/add_colaborador",method = RequestMethod.POST)
    public String addColaborador(RedirectAttributes flash, HttpServletRequest request, @RequestParam("aux")Integer aux, @RequestParam("id_persona")Long id_persona){

        if (request.getSession().getAttribute("persona") != null) {
			Long id_servicio = 0L;
            for (int i = 0; i < aux; i++) {
                if (request.getParameter("id_servicio" + i) != null) {
                    id_servicio=Long.parseLong(request.getParameter("id_servicio" + i));
                }
            }
            
            Colaborador colaborador = new Colaborador();
            colaborador.setPersona(personaService.findOne(id_persona));
            colaborador.setServicio(servicioService.findOne(id_servicio));
            colaborador.setFecha_recepcion(new Date());
            colaborador.setEstado("B");
            colaboradorService.save(colaborador);

            flash.addAttribute("validado", "Colaborador Añadido Con Exito!");
            
            return "redirect:/hardware-servicio/";
		} else {
			return "redirect:/hardware/login";
		} 
    }

    @RequestMapping("/ficha-tecnica/{id_servicio}")
    public String fichatecnica(Model model , @PathVariable("id_servicio")Long id_servicio, RedirectAttributes flash, HttpServletRequest request ){
        
         if (request.getSession().getAttribute("persona") != null) {
			model.addAttribute("servicio", servicioService.findOne(id_servicio));
            model.addAttribute("usuarios", usuarioService.findAll());
            return "ficha_tecnica";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/editar-servicio/{id_servicio}")
    public String editarServicio(Model model,@PathVariable("id_servicio")Long id_servicio, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
            Servicio servicio = servicioService.findOne(id_servicio);
            
			model.addAttribute("servicio", servicio);
            model.addAttribute("procedencias", procedenciaService.findAll());
            model.addAttribute("almacenes", almacenService.getAllAlmacenTipoEquipo(servicio.getTipoEquipo().getId_tipoequipo()));
            model.addAttribute("persona", personaService.findOne(servicio.getPersona().getId_persona()));
            model.addAttribute("tipoequipo", tipoEquipoService.findOne(servicio.getTipoEquipo().getId_tipoequipo()));
           
            return "editar_servicio";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/editar-perfil-usuario")
    public String editar_perfil_usuario(Model model,@RequestParam(name = "validado",required = false)String validado, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {

            if (validado != null) {
                model.addAttribute("validado", validado);
            }

            return "editar_Perfil_Usuario";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/editar_perfil",method = RequestMethod.POST)
    public String editar_perfil(Model model,@RequestParam("id_persona")Long id_persona,@RequestParam("nombre")String nombre,@RequestParam("ap_paterno")String ap_paterno,@RequestParam("ap_materno")String ap_materno,@RequestParam("ci")String ci,@RequestParam("celular")Integer celular, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
            Persona persona = personaService.findOne(id_persona);
            persona.setNombre(nombre);
            persona.setAp_paterno(ap_paterno);
            persona.setAp_materno(ap_materno);
            persona.setCi(ci);
            persona.setCelular(celular);
            personaService.save(persona);

            flash.addAttribute("validado", "Se actualizo los datos con exito!!, Porfavor volver a iniciar sesion...");
            return "redirect:/hardware-servicio/editar-perfil-usuario";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping(value = "/editar_usuario",method = RequestMethod.POST)
    public String editar_usuario(Model model,@RequestParam("id_usuario")Long id_usuario,@RequestParam("usuario")String usuario,@RequestParam("contrasena")String contrasena, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
            Usuario usuario2 = usuarioService.findOne(id_usuario);
            usuario2.setUsuario(usuario);
            usuario2.setContrasena(contrasena);
            usuarioService.save(usuario2);

            HttpSession session = request.getSession(false);
			session.invalidate();
			flash.addAttribute("validado", "Se actualizo los datos con exito!");
		
            return "redirect:/hardware/login";
		} else {
			return "redirect:/hardware/login";
		}
    }


    @RequestMapping("/historial_servicio/{id_almacen}")
    public String historialServicio(Model model,@PathVariable("id_almacen")Long id_almacen, RedirectAttributes flash, HttpServletRequest request ){

        if (request.getSession().getAttribute("persona") != null) {
            Almacen almacen = almacenService.findOne(id_almacen);
           
            model.addAttribute("servicios", almacen.getServicios());
            model.addAttribute("almacen", almacen);
            
            return "historial_servicio";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/informe_tecnico/{id_servicio}")
    public String informeTecnico(Model model,@PathVariable("id_servicio")Long id_servicio,RedirectAttributes flash, HttpServletRequest request ){
        if (request.getSession().getAttribute("persona") != null) {
           
            Servicio servicio = servicioService.findOne(id_servicio);
            
            model.addAttribute("tipoequipo", tipoEquipoService.findOne(servicio.getTipoEquipo().getId_tipoequipo()));
            model.addAttribute("servicio", servicio);
            model.addAttribute("baja", bajaService.findOne(servicio.getId_servicio()));
            
            return "informe_tecnico";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/informe_tecnico_baja/{id_servicio}")
    public String informeTecnicoBaja(Model model,@PathVariable("id_servicio")Long id_servicio,RedirectAttributes flash, HttpServletRequest request ){
        if (request.getSession().getAttribute("persona") != null) {
           
            Servicio servicio = servicioService.findOne(id_servicio);
            
            model.addAttribute("servicio", servicio);
            model.addAttribute("almacen", almacenService.getAllAlmacenTipoEquipo(servicio.getTipoEquipo().getId_tipoequipo()));
            
            return "informe_baja";
		} else {
			return "redirect:/hardware/login";
		}
    }

    @RequestMapping("/cerrar_sesion")
    public String cerrarSesion(HttpServletRequest request, RedirectAttributes flash){
        HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			flash.addAttribute("validado", "Se cerro sesion con exito!");
		}
		return "redirect:/hardware/login";
    }
    

    
}

