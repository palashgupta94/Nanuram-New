let addRow = function(){

    console.log('typeList -> ' , typeList);
    console.log('primaryList -> ' , primaryList);

    let listName = 'mobileNumbers';
    let fieldsname = ['type' , 'mobileNumber' , 'primary'];
    let rowCount =  $('#mobileNumberTable > tbody > tr').length;
    console.log(rowCount , ' rows are there');

    let newRow = document.createElement('tr');

    fieldsname.forEach((fieldName) =>{

        let tData = document.createElement('td');
        let div = document.createElement('div');

        if(fieldName === 'type'){

            let selectElement = document.createElement('SELECT')
            selectElement.classList.add('form-select' , 'col-sm-6');
            selectElement.setAttribute('name',listName+'[' + rowCount + '].' + fieldName);
            selectElement.id = listName+rowCount+'.'+fieldName;
            console.log(selectElement);


           for(let i = 0; i < typeList.length; i++){
               let optionElement = document.createElement('option');
               optionElement.value = typeList[i];
               optionElement.innerHTML = typeList[i];
               selectElement.appendChild(optionElement);
           }
            // selectElement.append(optionElement);
            div.append(selectElement);
            tData.append(div);
            newRow.append(tData);
            console.log(newRow)
        }

        else if(fieldName === 'primary'){

            let selectElement = document.createElement('SELECT')
            selectElement.classList.add('form-select' , 'col-sm-6');
            selectElement.setAttribute('name',listName+'[' + rowCount + '].' + fieldName);
            selectElement.id = listName+rowCount+'.'+fieldName;
            console.log(selectElement);


            for(let i = 0; i < primaryList.length; i++){
                let optionElement = document.createElement('option');
                optionElement.value = primaryList[i];
                optionElement.innerHTML = primaryList[i];
                selectElement.appendChild(optionElement);
            }
            // selectElement.append(optionElement);
            div.append(selectElement);
            tData.append(div);
            newRow.append(tData);
            console.log(newRow)

        }

        else{

            let inputElement = document.createElement('INPUT');
            inputElement.classList.add('form-control' , 'col-sm-6');
            inputElement.setAttribute('name',listName+'[' + rowCount + '].' + fieldName);
            inputElement.id = listName+rowCount+'.'+fieldName;
            console.log(inputElement);
            // selectElement.append(optionElement);
            div.append(inputElement);
            tData.append(div);
            newRow.append(tData);
            console.log(newRow)

        }


    });

    document.getElementById('tb').appendChild(newRow);


}