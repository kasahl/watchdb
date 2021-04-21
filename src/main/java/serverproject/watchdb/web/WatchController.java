package serverproject.watchdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import serverproject.watchdb.domain.Watch;
import serverproject.watchdb.domain.WatchRepository;

@Controller
public class WatchController {

	@Autowired
	private WatchRepository repository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	//ohjelman perusnäkymä
	@RequestMapping("/watchlist")
	public String watchList(Model model) {	
		model.addAttribute("watches", repository.findAll());
		return "watchlist";
	}
	
	//rest json
	@RequestMapping(value="/watches")
    public @ResponseBody List<Watch> watchlistRest() {	
        return (List<Watch>) repository.findAll();
    }  
	
	//rest jolla pystyy etsiä tietokannasta idllä
	@RequestMapping(value="/watch/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Watch> WatchRest(@PathVariable("id") Long watchId) {	
    	return repository.findById(watchId);
	}
	 
	//vie käyttäjän sivulle, jossa pystyy lisäämään uuden kellon
	@RequestMapping(value="/addwatch")
	public String addWatch(Model model){
	    model.addAttribute("watch", new Watch());
	    return "addwatch";
	}     
	    
	//tallentaa ja tuo käyttäjän takaisin kellolistalle
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Watch watch){
	    repository.save(watch);
	    return "redirect:watchlist";
	}
	
	//poistotoiminto, johon pitää olla ADMIN
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWatch(@PathVariable("id") Long watchId, Model model) {
    	repository.deleteById(watchId);
        return "redirect:../watchlist";
    }
    
	//muokkaus toiminto, johon pitää olla ADMIN
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String modifyBook(@PathVariable("id") Long watchId, Model model) {
		Optional<Watch> watch = repository.findById(watchId);
		model.addAttribute("watch", watch);
		return "editwatch";
    }
}
