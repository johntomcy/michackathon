"use strict";

const express = require('express')
const faker = require('faker/locale/zh_CN')
const logger = require('morgan')
const services = require('./service')
var jsonfile = require('jsonfile')

const app = express()

var airports = null

var file = 'airports.json'
jsonfile.readFile(file, function(err, obj) {
    airports = obj
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

app.get('/config', (req, res) => {
    services.getConfig('user-api-service').then((config) => {
        res.json(config)
    }).catch((e)=> next(e))
})

app.use((error, req, res, next) => {
    const status = 500 || error.status; 
    res.status(status)
    res.json({status, message: 'service error'})
})


app.listen(3000, () => console.log("express-application listening on 3000"))