package com.cydeo.service.impl;

import com.cydeo.client.CountryApiClient;
import com.cydeo.client.WeatherApiClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.weather.WeatherDTO;
import com.cydeo.entity.Address;
import com.cydeo.util.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Value("${access_key}")
    private String accessKey;
// ^^ accessKey stored as variable for re-usability (comes from application.properties)
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherApiClient weatherApiClient;
    private final CountryApiClient countryApiClient;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, WeatherApiClient weatherApiClient, CountryApiClient countryApiClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.weatherApiClient = weatherApiClient;
        this.countryApiClient = countryApiClient;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO findById(Long id) throws Exception {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new Exception("No Address Found!"));

        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());

    // we will get current temp. and set based on city
        addressDTO.setCurrentTemperature(retrieveTempByCity(addressDTO.getCity())
                .getCurrent().getTemperature());
    // we will get flag link based on the country provided
        addressDTO.setFlag(retrieveFlagByCountry(addressDTO.getCountry()));

        return addressDTO;
    }

    private String retrieveFlagByCountry(String country) {

        return countryApiClient.getCountryInfo(country).get(0).getFlags().getPng();
        // since the API returns a list of countries, ^^ need to get our country first
    }

    private WeatherDTO retrieveTempByCity(String city) {

        return weatherApiClient.getCurrentWeather(accessKey, city);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new Exception("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

}