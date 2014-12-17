from math import sqrt

primes = set([2])
value = 3
number = 600851475143
while value < sqrt(number):
    isPrime = True
    for k in primes:
        if value % k == 0:
            # only increment val if we find a non-prime the first time
            if isPrime:
                value += 2
            isPrime = False
    if isPrime:
        primes.add(value)
        if number % value == 0:
            print value
            number /= value
print number
