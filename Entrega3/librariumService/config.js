// var fs = require('fs')
// var env = process.env.PREPI_ENV
// if (!env) {
let env = 'dev' //dev | test | prod
// }

// var fixconfig = {
//     env: env,
//     jwt_secret: 'xxx',
//     token_expiration: '2592000',
//     bcrypt: {
//         salts: 4,
//         salgar: 'asfo78pa324a3w'
//     }
// }

var privateKey, certificate, ca

var envconfig

switch (env) {
    case 'dev':
        envconfig = {
            root: 'Librarium1 Server\n ,._\n@"_.)~\n W W\n dev',
            mongo: {
                address: 'mongodb://mongo:27017/librariumdb'
            },
            http: {
                port: 8080
            }
            // corswhitelist: ['localhost:[0-9]*$', '127[.]0[.]0[.]1:[0-9]*$']
        }
        break

    // case 'prod':
    //     envconfig = {
    //         root: 'Prepi1 Server\n ,._\n@"_.)~\n W W\n prod',
    //         mongo: {
    //             address:
    //                 'mongodb://oneservice:954piorwep92o3EWRs@ec2-18-206-228-28.compute-1.amazonaws.com:27017/one?authSource=admin'
    //         },
    //         http: {
    //             port: 8086
    //         },
    //         corswhitelist: ['prepi[.]com[.]br$', '127[.]0[.]0[.]1:[0-9]*$']
    //     }
}

exports.envconfig = envconfig
