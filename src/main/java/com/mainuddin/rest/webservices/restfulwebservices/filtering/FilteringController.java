package com.mainuddin.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering") //field2 eg password
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);;
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
        List<SomeBean> list = Arrays.asList(new SomeBean("value6","value7","value8")
                ,new SomeBean("value10","value11","value12"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field2","field3");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);;
        return mappingJacksonValue;
    }
}
