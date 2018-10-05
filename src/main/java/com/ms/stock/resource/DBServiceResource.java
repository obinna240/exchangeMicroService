package com.ms.stock.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.stock.model.Quote;
import com.ms.stock.model.Quotes;
import com.ms.stock.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {
	
	@Autowired
	public QuotesRepository quotesRepository;
	
	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {
		return getQuotesByUserName(username);
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {
		quotes.getQuotes()
		.stream()
		.map(quote -> new Quote(quotes.getUsername(), quote))
		.forEach(quote -> {
			quotesRepository.save(quote);
		});
		return getQuotesByUserName(quotes.getUsername());
	}
	
	@PostMapping("/delete")
	public List<String> delete(@PathVariable("username") final String username) {
		quotesRepository.deleteAll(quotesRepository.findByUsername(username));
		return getQuotesByUserName(username);
	}
	
	private List<String> getQuotesByUserName(@PathVariable("username") final String username)  {
		return quotesRepository.findByUsername(username).stream().map(quote -> {
			return quote.getQuote();
		}).collect(Collectors.toList());
	}

}
