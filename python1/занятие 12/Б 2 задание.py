#-- coding: utf-8 --
def code(nums):
    if len(nums) <= 1:
        return
    max_num = max(nums)
    nums.remove(max_num)
    return max(nums)
def code2():
    num = int(input("Введите число"))
    if num == 0:
        return []
    else:
        return [num] + code2()
p = code2()
c = code(p)
print("Второе по величине число:",c)
