def answer(s):
    ans = 1
    for count in range(2, 200):
        slices = count_slices(s, count)

        if slices > ans:
            ans = slices

        if count >= len(s)/2:
            return ans

def count_slices(s, num): 
    length = len(s)
    if length % num !=0:
        return 0

    parts = [s[i:i+num] for i in range(0, length, num)]

    slice_set = set(parts)
    if len(slice_set) == 1:
        return len(parts)
    
    return 0

print answer("abcabcabcabc")
print answer("abccbaabccba")
print answer("abcabcabcabc")
print answer("abccbaabccba")