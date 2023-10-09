let optionCounter = 1; // Initialize the counter

function onCreateOption() {
    document.querySelector("#btn-add-option").addEventListener("click", function() {
        const optionDiv = document.createElement("div");
        optionDiv.setAttribute("data-name", "option");
        const label = document.createElement("label");

        const childDiv = document.createElement("div");
        childDiv.className = "w-full flex items-center gap-2";
        label.textContent = "Phương án " + optionCounter; // Set the label text
        label.className = "text-sm"

        const input = document.createElement("input");
        input.type = "text";
        input.className = "block w-full rounded-md border-0 px-3.5 py-2 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6";
        childDiv.appendChild(input);

        const removeButton = document.createElement("button");
        removeButton.textContent = "Xóa";
        removeButton.className = "w-fit h-full border-none outline-none px-2 py-2 bg-red-700 text-white rounded-md"
        removeButton.addEventListener("click", function() {
            // Remove the parent div (option) when the remove button is clicked
            optionDiv.remove();
            renumberOptions(); // Renumber the remaining options
        });
        childDiv.appendChild(removeButton);

        optionDiv.appendChild(label);
        optionDiv.appendChild(childDiv);

        document.querySelector("#option-zone").appendChild(optionDiv);

        optionCounter++; // Increment the counter
    });
}

function renumberOptions() {
    const optionZone = document.querySelector("#option-zone");
    const options = optionZone.querySelectorAll("div[data-name='option']");

    // Renumber the remaining options
    options.forEach(function(option, index) {
        const label = option.querySelector("label");
        label.textContent = "Phương án " + (index + 1);
    });

    optionCounter = options.length + 1;
}

function onSubmit() {
    const options = [];
    const optionDivs = document.querySelectorAll("div[data-name='option']");

    optionDivs.forEach(function(optionDiv) {
        const input = optionDiv.querySelector("input[type='text']");
        const optionValue = input.value;
        if (input.value !== '')
            options.push(optionValue);
    });

    const optionsInput = document.querySelector("#question-options");
        optionsInput.value = JSON.stringify(options);

    console.log(JSON.stringify(options));
}

function onSelectHollandChange() {
    const selectElement = document.querySelector("#holland-field");
    const hiddenInputElement = document.querySelector("#selected-holland");

    selectElement.addEventListener("change", function() {
        hiddenInputElement.value = selectElement.value;
    })
}

onCreateOption();
onSelectHollandChange();