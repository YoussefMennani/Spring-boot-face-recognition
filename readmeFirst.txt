const dateNow = new Date();
postman.setGlobalVariable("todayDate", dateNow.toLocaleDateString());

  {

        "date": "{{todayDate}}"

    }