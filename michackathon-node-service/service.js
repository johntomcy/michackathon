const fetch = require('isomorphic-fetch')

const SIDECAR = {
    uri: 'http://node-sidecar-service:8741'
}

const USER_SERVICE = 'user-api-service'
const CONFIG_SERVER = 'config-service'

exports.getConfigServerInfo = () => fetch(`${SIDECAR.uri}/hosts/${CONFIG_SERVER}`).then((resp)=>resp.json())

exports.getConfig = (configName) => fetch(`${SIDECAR.uri}/${CONFIG_SERVER}/${configName}.yml`).then((resp)=>resp.json())

exports.getUserById = (id) => fetch(`${SIDECAR.uri}/${USER_SERVICE}/${id}`).then((resp)=>resp.json())