
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class talisman {
	private String[] lines;
	public talismanSkill[] ts = new talismanSkill[204];
	private String skill_limits_mhxx = "0 = なし			: : : : : : : : : :\n"
			+ "1 = 毒			: 1~5 | 0~0 : : 1~5 | -10~7 : : 0~0 | 0~0 : : : : :\n"
			+ "2 = 麻痺			: 1~5 | 0~0 : : 1~5 | -10~7 : : 0~0 | 0~0 : : : : :\n"
			+ "3 = 睡眠			: 1~5 | 0~0 : : 1~5 | -10~7 : : 0~0 | 0~0 : : : : :\n"
			+ "4 = 气绝			: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "5 = 听觉保护		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "6 = 风压			: : : 1~4 | 0~0 : : 1~4 | -10~9 : : : : :\n"
			+ "7 = 耐震			: 1~7 | 0~0 : : 1~7 | -10~8 : : 0~0 | 0~0 : : : : :\n"
			+ "8 = だるま			: 1~7 | 0~0 : : 1~7 | -10~8 : : 0~0 | 0~0 : : : : :\n"
			+ "9 = 耐暑			: 1~10 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "10 = 耐寒		: 1~10 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "11 = 寒冷适应		: : : : : 1~5 | 0~0 : : : : :\n"
			+ "12 = 炎热适应		: : : : : 1~5 | 0~0 : : : : :\n"
			+ "13 = 偷盗无效		: 1~10 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "14 = 对防御DOWN	: 1~7 | 0~0 : : 1~7 | -10~8 : : 0~0 | 0~0 : : : : :\n"
			+ "15 = 狂击耐性		: 1~3 | 0~0 : : 0~0 | -5~5 : : 1~5 | 0~0 : : : : :\n"
			+ "16 = 细菌学		: : : 0~0 | -5~5 : : 1~8 | 0~0 : : : : :\n"
			+ "17 = 裂伤		: 1~5 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "18 = 攻击		: 1~4 | 0~0 : : 1~4 | -7~7 : : 0~0 | -10~10 : : : : :\n"
			+ "19 = 防御		: 1~4 | 0~0 : : 1~4 | -7~7 : : 0~0 | -10~10 : : : : :\n"
			+ "20 = 体力		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "21 = 火耐性		: 1~6 | 0~0 : : 1~6 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "22 = 水耐性		: 1~6 | 0~0 : : 1~6 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "23 = 雷耐性		: 1~6 | 0~0 : : 1~6 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "24 = 冰耐性		: 1~6 | 0~0 : : 1~6 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "25 = 龙耐性		: 1~6 | 0~0 : : 1~6 | -10~10 : : 0~0 | -10~13 : : : : :\n"
			+ "26 = 属性耐性		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "27 = 火属性攻击	: : : 1~7 | 0~0 : : 1~7 | -10~13 : : : : :\n"
			+ "28 = 水属性攻击	: : : 1~7 | 0~0 : : 1~7 | -10~13 : : : : :\n"
			+ "29 = 雷属性攻击	: : : 1~7 | 0~0 : : 1~7 | -10~13 : : : : :\n"
			+ "30 = 冰属性攻击	: : : 1~7 | 0~0 : : 1~7 | -10~13 : : : : :\n"
			+ "31 = 龙属性攻击	: : : 1~7 | 0~0 : : 1~7 | -10~13 : : : : :\n"
			+ "32 = 属性攻击		: : : : : 1~5 | 0~0 : : : : :\n"
			+ "33 = 特殊攻击		: : : 1~4 | -4~4 : : 1~6 | -10~4 : : : : :\n"
			+ "34 = 研ぎ師		: : : 1~4 | 0~0 : : 0~0 | -10~8 : : : : :\n"
			+ "35 = 匠			: : : : : 0~0 | -5~5 : : : : :\n"
			+ "36 = 斩位		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "37 = 剑术		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "38 = 研磨术		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "39 = 钝器		: : : 1~4 | 0~0 : : 1~6 | 0~0 : : : : :\n"
			+ "40 = 拔刀会心		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "41 = 拔刀減気		: : : 0~0 | -5~5 : : 0~0 | -5~8 : : : : :\n"
			+ "42 = 纳刀		: : : 1~6 | 0~0 : : 1~6 | -10~4 : : : : :\n"
			+ "43 = 纳刀研磨	: 1~4 | -1~1 : : : : : : : : :\n"
			+ "44 = 刃鳞		: 1~4 | -1~1 : : : : : : : : :\n"
			+ "45 = 装填速度		: : : 1~4 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "46 = 反动		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "47 = 精密射击		: 1~6 | 0~0 : : 1~6 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "48 = 通常弹強化	: : : : : 1~5 | -3~3 : : : : :\n"
			+ "49 = 贯通弹强化	: : : : : 1~5 | -3~3 : : : : :\n"
			+ "50 = 散弹强化		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "51 = 重击弹强化	: : : : : 1~5 | -3~3 : : : : :\n"
			+ "52 = 通常弹追加	: 1~8 | 0~0 : : 1~6 | -8~8 : : 0~0 | 0~0 : : : : :\n"
			+ "53 = 贯通弹追加	: 1~8 | 0~0 : : 1~10 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "54 = 散弹追加		: 1~8 | 0~0 : : 1~10 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "55 = 榴弹追加		: 1~8 | 0~0 : : 1~10 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "56 = 扩散弹追加	: 1~8 | 0~0 : : 1~10 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "57 = 毒瓶追加		: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "58 = 麻痺瓶追加	: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "59 = 睡眠瓶追加	: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "60 = 强击瓶追加	: 1~8 | 0~0 : : 0~0 | -10~12 : : 0~0 | 0~0 : : : : :\n"
			+ "61 = 属强瓶追加	: 1~8 | 0~0 : : 0~0 | -10~12 : : 0~0 | 0~0 : : : : :\n"
			+ "62 = 接击瓶追加	: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "63 = 灭气瓶追加	: 1~8 | 0~0 : : 1~10 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "64 = 爆破瓶追加	: 1~8 | 0~0 : : 1~10 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "65 = 速射		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "66 = 射法		: : : 0~0 | -3~3 : : 1~3 | -5~5 : : : : :\n"
			+ "67 = 装填数		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "68 = 变则射击		: 1~5 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "69 = 弹药节约		: : : 1~3 | -5~5 : : 1~5 | -5~5 : : : : :\n"
			+ "70 = 达人		: 1~4 | 0~0 : : 1~4 | -7~7 : : 0~0 | -10~10 : : : : :\n"
			+ "71 = 痛击		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "72 = 连击		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "73 = 特殊会心		: : : 1~3 | -5~5 : : 1~5 | 0~0 : : : : :\n"
			+ "74 = 属性会心		: : : 1~3 | -5~5 : : 1~5 | 0~0 : : : : :\n"
			+ "75 = 会心强化		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "76 = 里会心		: 1~4 | -1~1 : : : : : : : : :\n"
			+ "77 = 蓄力缩短		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "78 = スタミナ		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "79 = 体术		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "80 = 气力回复		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "81 = 走行继续			: 1~4 | -1~1 : : : : : : : : :\n"
			+ "82 = 回避性能		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "83 = 回避距离		: : : : : 1~6 | -3~4 : : : : :\n"
			+ "84 = 泡沫		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "85 = 防御性能		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "86 = 防御强化		: : : 1~4 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "87 = KO			: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "88 = 减气攻撃		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "89 = 笛			: 1~6 | 0~0 : : 1~6 | -8~8 : : 0~0 | -10~10 : : : : :\n"
			+ "90 = 砲术		: 1~6 | 0~0 : : 1~6 | -8~8 : : 0~0 | -10~10 : : : : :\n"
			+ "91 = 重击		: : : : : 1~5 | -3~3 : : : : :\n"
			+ "92 = 爆弹强化		: 1~6 | 0~0 : : 1~6 | -8~8 : : 0~0 | -10~10 : : : : :\n"
			+ "93 = 本气		: : : : : 1~6 | -3~4 : : : : :\n"
			+ "94 = 斗魂		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "95 = 无伤		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "96 = チャンス		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "97 = 龙气		: 1~4 | -1~1 : : : : : : : : :\n"
			+ "98 = 底力		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "99 = 逆境		: 1~4 | 0~0 : : 1~5 | -5~5 : : 0~0 | 0~0 : : : : :\n"
			+ "100 = 逆上		: : : 1~3 | -5~5 : : 1~5 | -5~5 : : : : :\n"
			+ "101 = 穷地		: : : 1~3 | -5~5 : : 1~5 | -5~5 : : : : :\n"
			+ "102 = 根性		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "103 = 气配		: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "104 = 采配		: 1~3 | 0~0 : : 1~5 | -7~7 : : 1~7 | -10~10 : : : : :\n"
			+ "105 = 号令		: 1~3 | 0~0 : : 1~5 | -7~7 : : 1~7 | -10~10 : : : : :\n"
			+ "106 = 骑乘		: 1~10 | 0~0 : : 0~0 | -8~8 : : 0~0 | -5~5 : : : : :\n"
			+ "107 = 跳跃		: : : 1~3 | -5~5 : : 1~5 | -5~5 : : : : :\n"
			+ "108 = 无心		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "109 = 我慢		: 1~4 | -1~1 : : : : : : : : :\n"
			+ "110 = ＳＰ延長	: 1~4 | -1~1 : : : : : : : : :\n"
			+ "111 = 千里眼		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | -10~12 : : : : :\n"
			+ "112 = 观察眼		: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "113 = 狩人		: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "114 = 搬运		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "115 = 加护		: : : 1~7 | 0~0 : : 1~7 | -10~9 : : : : :\n"
			+ "116 = 英雄之盾	: : : : : 0~0 | -3~3 : : : : :\n"
			+ "117 = 回复量		: : : 1~6 | 0~0 : : 1~6 | -3~4 : : : : :\n"
			+ "118 = 回复速度	: : : 1~7 | -4~4 : : 0~0 | -10~12 : : : : :\n"
			+ "119 = 效果持续	: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "120 = 广域		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | -10~12 : : : : :\n"
			+ "121 = 腹减		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | -10~10 : : : : :\n"
			+ "122 = 食いしん坊	: 1~10 | 0~0 : : 0~0 | -10~13 : : 0~0 | 0~0 : : : : :\n"
			+ "123 = 食事		: : : 1~4 | 0~0 : : 1~5 | -3~3 : : : : :\n"
			+ "124 = 节食		: : : 1~3 | -5~5 : : 1~5 | -5~5 : : : : :\n"
			+ "125 = 肉食		: : : 1~3 | -5~5 : : 1~5 | -5~5 : : : : :\n"
			+ "126 = 茸食		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "127 = 野草知识		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "128 = 调合成功率	: 1~10 | 0~0 : : 0~0 | -10~13 : : 0~0 | 0~0 : : : : :\n"
			+ "129 = 调合数		: 1~8 | 0~0 : : 0~0 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "130 = 高速设置		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "131 = 采取		: 1~10 | 0~0 : : 0~0 | -10~13 : : 0~0 | 0~0 : : : : :\n"
			+ "132 = ハチミツ		: 1~8 | 0~0 : : 1~8 | -10~10 : : 0~0 | 0~0 : : : : :\n"
			+ "133 = 护石王		: : : 1~3 | -5~5 : : 1~7 | -8~10 : : : : :\n"
			+ "134 = 気まぐれ		: 1~10 | 0~0 : : 0~0 | -10~13 : : 0~0 | 0~0 : : : : :\n"
			+ "135 = 运气		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "136 = 剥取		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "137 = 捕获		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "138 = ベルナ		: : : : : : : : : :\n"
			+ "139 = ココット		: : : : : : : : : :\n"
			+ "140 = ポッケ		: : : : : : : : : :\n"
			+ "141 = ユクモ		: : : : : : : : : :\n"
			+ "142 = 龙识船		: : : : : : : : : :\n"
			+ "143 = 飞行酒厂		: : : : : : : : : :\n"
			+ "144 = 红兜		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "145 = 大雪主		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "146 = 矛碎		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "147 = 岩穿		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "148 = 紫毒姫		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "149 = 宝缠		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "150 = 白疾风		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "151 = 只眼		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "152 = 黑炎王		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "153 = 金雷公		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "154 = 荒钩爪		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "155 = 烬灭刃		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "156 = 胧隐		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "157 = 铠裂		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "158 = 天眼		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "159 = 青电主		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "160 = 银岭		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "161 = 鏖魔		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "162 = 真・红兜		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "163 = 真・大雪主		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "164 = 真・矛碎		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "165 = 真・岩穿		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "166 = 真・紫毒姫		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "167 = 真・宝缠		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "168 = 真・白疾风		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "169 = 真・只眼		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "170 = 真・黑炎王		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "171 = 真・金雷公		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "172 = 真・荒钩爪		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "173 = 真・烬灭刃		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "174 = 真・胧隐		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "175 = 真・铠裂		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "176 = 真・天眼		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "177 = 真・青电主		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "178 = 真・银岭		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "179 = 真・鏖魔		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "180 = 北辰纳豆流		: : : : : : : : : :\n"
			+ "181 = 斩术		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "182 = 食欲		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "183 = 职工		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "184 = 刚腕		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "185 = 祈愿		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "186 = 里稼业		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "187 = 刀匠		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "188 = 射手		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "189 = 状态耐性		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "190 = 怒		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "191 = 回避术		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "192 = 居合		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "193 = 顽强		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "194 = 刚击		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "195 = 盾持		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "196 = 洁癖		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "197 = 增幅		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "198 = 护石收集		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "199 = 强欲		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "200 = 对钢龙		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "201 = 对霞龙		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "202 = 对炎龙		: : : : : 0~0 | -3~3 : : : : :\n"
			+ "203 = 胴系统倍加?	: : : : : : : : : :\n";
	public talisman(){
		parseSkills();
	}
	
	public enum ItemType {
	    First("First choice", 1), Second("Second choice", 2), Third("Final choice", 3);
	    private final String display;
	    private int index;  
	    private ItemType(String s, int i) {
	        display = s;
	        index = i;
	    }
	    public static int getIndex(String s) {  
	        for (ItemType c : ItemType.values()) {  
	            if (c.getName() == s) {  
	                return c.index;  
	            }  
	        }  
	        return 0;  
	    }  
	    public int getIndex() {
	    	return index;
	    }
	    public String getName() {
	    	return display;
	    }
	    @Override
	    public String toString() {
	        return display;
	    }
	}
	
	public enum tType {
		R0("---"), R1("兵士护石"), R2("斗士护石"), R3("骑士护石"), R4("城赛护石"), R5("女王护石"), R6("王之护石"), R7("龙之护石"), R8("英雄护石"), R9("传说护石"), R10("天之护石");
		private final String typeName;
		private tType(String s) {
			typeName = s;
		}
		public static tType getIndex(String s) {  
	        for (tType c : tType.values()) {  
	            if (c.toString() == s) {  
	                return c;  
	            }  
	        }  
	        return R0;  
	    }
	    @Override
	    public String toString() {
	        return typeName;
	    }
	    public static int getCode(String s){
	    	tType t = getIndex(s);
	    	switch (t){
	    	case R1: return 1;
	    	case R2: return 2;
	    	case R3: return 3;
	    	case R4: return 4;
	    	case R5: return 5;
	    	case R6: return 6;
	    	case R7: return 7;
	    	case R8: return 8;
	    	case R9: return 9;
	    	case R10: return 10;
	    	default: return 0;
	    	}
	    }
	    public int getCode(tType t){
	    	switch (t){
	    	case R1: return 1;
	    	case R2: return 2;
	    	case R3: return 3;
	    	case R4: return 4;
	    	case R5: return 5;
	    	case R6: return 6;
	    	case R7: return 7;
	    	case R8: return 8;
	    	case R9: return 9;
	    	case R10: return 10;
	    	default: return 0;
	    	}
	    }
	}
	
	public class range {
		int min;
		int max;
		public range(int min, int max){
			this.min = min;
			this.max = max;
		}
	} 
	
	public class talismanSkill {
		public String skill;
		public int number;
		range[] skill1_limit = new range[4]; 
		
		public talismanSkill(String skill, int number){
			this.skill = skill;
			this.number = number;
		}
		
		public String getSkill(){
			return skill;
		}
		
		public int getNum(){
			return number;
		}
		
		@Override
		public String toString(){
			return skill;
		}
		
	}
	
	public void parseSkills(){
		String reg = "[0-9]+\\s*=\\s*+\\S+.*";
		Pattern pattern = Pattern.compile(reg);
		lines = skill_limits_mhxx.split("\n");
		for (int i=0; i<204; i++){
			String[] tmp = lines[i].split("\\s");
			ts[i] = new talismanSkill(tmp[2], Integer.parseInt(tmp[0]));
			//System.out.print(tmp[2] + ", " + Integer.parseInt(tmp[0])+"\n");
		}
	}
	
//	public void parseSkills_v2(){
//		JFileChooser f = new JFileChooser();
//		try {
//			FileInputStream in = new FileInputStream(file.getPath());
//			in.read(Main.buffer);
//			in.close();
//		}catch(Exception exc){
//			JOptionPane.showMessageDialog(null, "请加载正确的存档文件System");
//		}
//	}
	
	public static void addtalisman(int typeCode, int sk1Code, int sk2Code, int sk1Num, int sk2Num, int slot){
		if (Main.emptySpaceInEquipBoxOffset >= 72000){
			JOptionPane.showMessageDialog(null, "添加失败，您的装备箱可能已满");
			return;
		}
		int emptySpaceOffset = findEmptySpace();
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset] = 6;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 2] = (byte) typeCode;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 12] = (byte) sk1Code;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 13] = (byte) sk2Code;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 14] = (byte) sk1Num;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 15] = (byte) sk2Num;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 16] = (byte) slot;
		if (typeCode == 1 || typeCode == 2  || typeCode == 3 || typeCode == 4)	Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)98;
		else if (typeCode == 5 || typeCode == 6  || typeCode == 7) Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)99;
		else if (typeCode == 8 || typeCode == 9  || typeCode == 10) Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 18] = (byte)100;
		Main.buffer[Main.useroffset + Main.equipmentBoxOffset + emptySpaceOffset + 19] = (byte)01;
		JOptionPane.showMessageDialog(null, "护石添加成功");
	} 
	
	public static int findEmptySpace(){
		for (int i = 0; i<36; i++){
			if (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + Main.emptySpaceInEquipBoxOffset + i] != (byte)0){
				Main.emptySpaceInEquipBoxOffset += 36;
				return findEmptySpace();
			}
		}
		return Main.emptySpaceInEquipBoxOffset;
	}
		
	
//	public static void main(String [ ] args)
//	{
//		String reg = "[0-9]+\\s*=\\s*+\\S+.*";
//		String str = "2 = 麻痺			: 1~5 | 0~0 : : 1~5 | -10~7 : : 0~0 | 0~0 : : : : :";
//		System.out.print(Pattern.matches(reg, str));
//		String[] res = str.split(" ");
//	    for (String out : res) {
//	        if (!"".equals(out)) {
//	            System.out.print(out+"\n");
//	        }
//	    }
//		talisman t = new talisman();
//		t.parseSkills();
//	}

}
