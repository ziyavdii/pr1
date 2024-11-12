file_name = "numberss.txt"

try:
    with open(file_name, "r") as file:
        numbers = []
        for line in file:
            try:
                number = float(line.strip())
                numbers.append(number)
            except ValueError:
                continue

    if numbers:
        total_sum = sum(numbers)
        maximum = max(numbers)
        
        with open(file_name, "a") as file:
            file.write(f"{total_sum}\n")
            file.write(f"{maximum}\n")

        print(f"Сумма чисел ({total_sum}) и максимум ({maximum}) добавлены в файл.")
    else:
        print("Файл не содержит чисел для обработки.")
    
except FileNotFoundError:
    print("Файл не найден. Убедитесь, что numberss.txt существует.")
except Exception as e:
    print(f"Произошла ошибка: {e}")