"use strict";

const express = require('express')
const faker = require('faker/locale/zh_CN')
const logger = require('morgan')
const services = require('./service')
const cors = require('cors')
var jsonfile = require('jsonfile')

const app = express()

app.use(cors());

var airports = null
var airportssearch = null
var recommendations = null

var airportfile = 'airports.json'
jsonfile.readFile(airportfile, function(err, obj) {
    airports = obj
})

var airportsearchfile = 'searchdata.json'
jsonfile.readFile(airportsearchfile, function(err, obj) {
    airportssearch = obj
})

var recommendationfile = 'recommendations.json'
jsonfile.readFile(recommendationfile, function(err, obj) {
    recommendations = obj
})

app.get('/', (req, res) => {
    res.json({
        status: 'Tomcy Service'
    })
})

app.use(logger('combined'))

app.get('/health', (req, res) => {
    res.json({
        status: 'UP'
    })
})

app.get('/airports', (req, res) => {
    res.json(airports)
})

app.get('/airports/iatacode/:startswith', (req, res) => {
    const airportStartsWith = (req.params.startswith).toUpperCase()
    res.json(airports.filter((airport)=>
        airport.iata.startsWith(airportStartsWith)
    ))
})

app.get('/flights/search', (req, res) => {
    res.json(airportssearch)
    // res.json({
    //     status: 'UP'
    // })
})

app.get('/flights/recommendations', (req, res) => {
    res.json(recommendations)
})

app.get('/config', (req, res) => {
    services.getConfig('node-sidecar-service').then((config) => {
        res.json(config)
    }).catch((e)=> next(e))
})

app.use((error, req, res, next) => {
    const status = 500 || error.status; 
    res.status(status)
    res.json({status, message: 'service error'})
})


app.listen(3000, () => console.log("express-application listening on 3000"))