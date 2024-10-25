// This setup allows running Apicurio Studio on different ports other than 8888 / 8080 to make it easier to
// use these ports for service development.
const ApicurioStudioConfig = {
    "apis": {
        "studio": "http://localhost:9080/apis/studio/v1"
    },
    "ui": {},
    "components": {
        "masthead": {},
        "editors": {},
        "nav": {}
    },
    "auth": {}
};
