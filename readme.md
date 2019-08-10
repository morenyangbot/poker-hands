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
5. 判断是否是 threeOfAKind
6. 判断是否是 straight
7. 判断是否是 flush
8. 判断是否是 fullHouse
9. 判断是否是 fourOfAKind
10. 判断是否是 straightFlush

**以上判断为严格判断，用例如上**

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