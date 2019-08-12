# Poker Hands

## tasks

1. 根据牌号比大小

```
AH.compare(2S) -> true
```

2. PokerHand 构造后自动根据牌号排序
```
AH, 2S, 3D, TC, 8H -> 2S, 3D, 8H, TC, AH
```

3. 判断是否是pair

```
AH, AC, KH, JH, TD -> true
AH, AC, AD, KH, JH -> false
```

4. 判断是否是 twoPair

```
AH, AC, KH, KC, TD -> true
```

```
AH, AC, AC, KC, KH -> false
```

5. 判断是否是 threeOfAKind

```
AH, AC, AC, KC, KH -> true
```
```
AH, AC, KH, KC, TD -> false
```

6. 判断是否是 straight

```
AH, KC, JS, QD, TD -> true
AH, AC, KC, JH, QD -> false

// 同花顺false
AH, KH, JH, QH, TH -> false

```

7. 判断是否是 flush
```
AH, AH, JH, QH, TH -> true

// 同花顺 false
AH, KH, JH, QH, TH
```

8. 判断是否是 fullHouse
```
AH, AS, AD, QD, QH -> true
AH, AS, AD, AC, QH -> false
```
9. 判断是否是 fourOfAKind
```
AH, AS, AD, AC, QH -> true
AH, AS, AD, QD, QH -> false
```

10. 判断是否是 straightFlush
```
AH, KH, JH, QH, TH -> true
AH, AH, JH, QH, TH -> false
AH, KC, JS, QD, TD -> false
```

11. 获取一手牌中的Case类型

```
AH, AC, KH, JH, TD -> Pair
AH, 2S, 3D, TC, 8H -> High Card
```

12. 根据最大数字的牌判断两手牌谁赢
```
( AH, 2S, 3D, TC, 8H ).compare( KH, 2S, 3D, TC, 8H ) -> true
```

13. 两手不同Case的牌根据Case的优先级比较谁赢
```
( AH, 2S, 3D, TC, 8H ).compare( KH, KS, 3D, TC, 8H ) -> false
```

13. 两手Case相同时，根据剩余的大牌比较谁赢
```
( KH, KS, 3D, TC, 8H ).compare( KH, KS, 3D, 9S, 8H ) -> true
```
