package com.home.androidnavigationsharedelementsdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.home.androidnavigationsharedelementsdemo.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    /**
     * 創建Fragment需要顯示的View, 默認返回 null
     * 當返回的View不為null時, View被銷毀時會調用onDestroyView()
     * 此處應該只進行佈局的初始化, 而不應該執行耗時操作, 如網絡請求 數據庫讀取
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    /**
     * 該方法在onCreateView()之後會被立即執行
     * 此時可以對View對象進行賦值, 當然在onCreateView()中也可以執行
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val (name, identity, moreIntroduction) = initializeDataAndView()
        materialCardView.setOnClickListener {
            materialCardView.isClickable = false
            avatarView.apply { isAnimating = true } // 開始轉動的動畫
            val extras = FragmentNavigatorExtras(
                onePieceImageView to getString(R.string.one_piece),
                avatarView to getString(R.string.wanted_order),
                nameTextView to getString(R.string.name),
                identityTextView to getString(R.string.identity),
                introductionTextView to getString(R.string.introduction)
            )
            val args = SecondFragmentArgs.Builder() // Rebuild項目, 會自動生成對應的參數類, 規則 fragment的類名+Args
            args.name = name
            args.identity = identity
            args.moreIntroduction = moreIntroduction
            val argsBundle = args.build().toBundle()
            val delayMillis = 2500.toLong()
            avatarView.postDelayed({
                avatarView.apply { isAnimating = false } // 在2.5秒後, 停止轉動的動畫
                findNavController().navigate(R.id.secondFragmentAction, argsBundle, null, extras) // 跳轉至DetailFragment
            }, delayMillis)
        }
    }

    private fun initializeDataAndView(): Triple<String, String, String> {
        val name = "モンキー・D・ルフィ"
        val identity = "麦わらの一味船長"
        val introduction =
            "底抜けの楽観主義者。後先を考えない行動が「自身の危険」「周囲の怒り」を招くこともしばしばある[注 3]が、どのような困難にも臆さず立ち向かう姿勢には、好感を抱いている人間も少なくない。\n" +
                    "\n" +
                    "思考回路に難があり、理論的な話は苦手。現象を説明されて理解できないと「不思議○○か」と勝手に納得する。また、詳しい説明よりも「不思議｣という単語を含めて説明した方が呑み込みが早い。さらに記憶力が非常に悪く、過去に対戦したことのある相手すら忘れてしまうほど。\n" +
                    "\n" +
                    "かなりのお調子者でもあり、ウソップやチョッパーとよくふざけ合っている。揃ってロボットや兵器、忍者などに心を震わせることが多いが、その一方でヒーローになることを嫌う……"
        val moreIntroduction =
            "底抜けの楽観主義者。後先を考えない行動が「自身の危険」「周囲の怒り」を招くこともしばしばある[注 3]が、どのような困難にも臆さず立ち向かう姿勢には、好感を抱いている人間も少なくない。\n" +
                    "\n" +
                    "思考回路に難があり、理論的な話は苦手。現象を説明されて理解できないと「不思議○○か」と勝手に納得する。また、詳しい説明よりも「不思議｣という単語を含めて説明した方が呑み込みが早い。さらに記憶力が非常に悪く、過去に対戦したことのある相手すら忘れてしまうほど。\n" +
                    "\n" +
                    "かなりのお調子者でもあり、ウソップやチョッパーとよくふざけ合っている。揃ってロボットや兵器、忍者などに心を震わせることが多いが、その一方でヒーローになることを嫌う[注 4]。\n" +
                    "\n" +
                    "大の冒険好き。「夢・信念・仲間」のためなら死をも恐れない。個性的な仲間たちのお陰で航海ができていることを強く認識しており、それゆえ仲間のことを何よりも大切に思っており、仲間からの信頼も厚い。同時に自身が強くなることで仲間や友達を守り、大切な人達が離れて行かないようにと心掛けている。\n" +
                    "\n" +
                    "非常に好奇心旺盛で、人並み外れた行動と思考力の持ち主。周囲に半ば呆れられながらも、作中屈指の大物たちには器が大きいと認められ、出会った人間の多数から無類の好感を抱かれている。それゆえ、世間からも懸賞金の高さで一目置かれるまでになる[注 5]。また、海賊王ゴール・D・ロジャーを知る者からは「ロジャーに似ている」と度々感じ取られている。ミホークは、次々と他人を味方に付けるルフィの力を「この海において最も恐るべき力」と称している。ルフィにとっての海賊王とは偉い者や支配者ではなく誰よりも「自由」であることであり、海賊として名を上げることが一番ではない。\n" +
                    "\n" +
                    "大の宴好き。無類の大食漢であり、一味の生活費の大半が彼の食費に消える。特に肉料理が大好物[5]。ナミによると生きているだけで人の3倍のエネルギーを消費するらしく、満腹になるまで暴食すると瞬間的に太るがすぐに元に戻る。歯が欠けても牛乳を飲むだけで治る。ルフィを海軍船に匿っていたハンコックの発言から、「一食100kg以上で1日5回」も食べる[注 6]。一応食欲には限度がありクラッカー戦でビスケットを夜通し食べたときは根を上げていた。一味の食糧を盗み喰いする事も多く、サンジを怒らせる事が多々ある。ウォーターセブン編では寝たまま食べる技を身につけた。ただし、アラバスタ編でトトが真剣に集めた貴重な水を喉が渇いても我慢をして飲まないようにするなどの自制心は持ち合わせている。アーロンパーク編で豪語した通り、料理の腕は非常に悪い[注 7]。\n" +
                    "\n" +
                    "基本的に美醜感覚は疎い。とはいえ皆無ではなく、能力者となったアルビダの事を見た際には「美女」と言っている[注 8]。ボン・クレーがナミに化けて服を脱いだ時や、アラバスタで女風呂を覗きナミの裸を見た時には反応していたが、老若男女誰もがメロメロになる程の美女ボア・ハンコックの色気や裸には無反応だった。作者曰くウソップが横にいる時のみ彼につられて「修学旅行の悪ノリ」で色気に反応するらしい[26]。色恋沙汰はある程度理解しているらしく、ハンコックに言い寄られた時は「結婚はしねえ」ときっぱり断っている。\n" +
                    "\n" +
                    "外見的特徴をネタにしたあだ名を躊躇なくつける（壮年男性は「○○のおっさん｣、オカマキャラは「○○ちゃん」と呼ぶ）。\n" +
                    "\n" +
                    "基本的に誰に対しても（年配者や大物であろうと）同等の態度で接し、礼儀作法も満足に行き届いていない。さらに無頓着な性分という点も相まって、世間的な有名人物すら知らないという場面も多い[注 9]。\n" +
                    "\n" +
                    "本質的には心根の優しい性分。相手の立場・年齢・種族を超えて一切の偏見なく受け入れる包容力を持ち合わせ、気に入った者を仲間に誘うこともある。しかし仲間や部下を平然と傷つける人物は激しく嫌っている。幼少期の一件から山賊にもいい印象を持っていない（親交あるダダン一家は例外）。\n" +
                    "\n" +
                    "単純明快な性格ゆえ、催眠術や暗示などを用いる相手には極端に弱く、苦戦を強いられることが多い[注 10]。また、良くも悪くも嘘がつけない面があり、結果的に事態を悪化させてしまうこともある。\n" +
                    "\n" +
                    "作中ではあまり強調されていないものの、「大金（1億ベリー）の入ったトランクケースを誤って海へ落す」「（上記の宴好きも相まって）1夜で9900万ベリーを使い切る」など、金銭感覚が非常に緩い（いずれの際もナミから鉄拳制裁を受けている）。また、新しい港に着くたびにナミから小遣いをもらっては、その全額を食費に費やしている（ウォーターセブン編など）。\n" +
                    "\n" +
                    "自分が間違っていたと分かれば、その非を認めてすぐに謝罪するなど、思考には柔軟性がある。犠牲を出る事を嫌うネフェルタリ・ビビに対しては「それでも人は死ぬぞ」と厳しく指摘した上で自分を頼るよう手を差し伸べるなど、理想ばかりではなく過酷な現実を直視する覚悟とそれでも諦めない責任感を合わせ持っている。\n" +
                    "\n" +
                    "ルフィの心理を描写するモノローグは一切使用されていない。これは作者のポリシーとしてルフィが読者に対して常にストレートな男である為に「考えるくらいなら口に出す・行動に移す」ということを徹底させてあるからである[26][注 11]。"
        nameTextView.text = name
        identityTextView.text = identity
        introductionTextView.text = introduction
        Glide.with(context!!).load(R.drawable.background_one_piece).centerCrop().into(onePieceImageView)
        Glide.with(context!!).load(R.drawable.icon_wanted_order).centerCrop().into(avatarView)
        return Triple(name, identity, moreIntroduction)
    }
}